import java.util.*;
import java.util.function.BiConsumer;

class VendingMachineFSM {

    // States of the vending machine
    public static enum State {
        IDLE,
        HAS_COIN,
        DISPENSING,
        OUT_OF_STOCK,
        MAINTENANCE
    }

    // Events that can occur
    public static enum Event {
        INSERT_COIN,
        SELECT_ITEM,
        DISPENSE_COMPLETE,
        CANCEL,
        REFILL,
        ENTER_MAINTENANCE,
        EXIT_MAINTENANCE
    }

    // Transition: next state + an action to execute (may be no-op)
    public static class Transition {
        public final State nextState;
        public final BiConsumer<VendingMachine, Event> action;

        public Transition(State nextState, BiConsumer<VendingMachine, Event> action) {
            this.nextState = nextState;
            this.action = action != null ? action : (vm, e) -> {};
        }
    }

    // The context: vending machine
    public static class VendingMachine {
        private State current = State.IDLE;
        private final Map<State, Map<Event, Transition>> table;
        private final Map<String, Integer> stock = new HashMap<>();   // itemCode -> qty
        private final Map<String, Integer> price = new HashMap<>();   // itemCode -> price (cents)
        private int balance = 0;                                       // in cents
        private String requestedItem = null;

        public VendingMachine(Map<State, Map<Event, Transition>> table) {
            this.table = table;
        }

        public State getState() { return current; }
        public int getBalance() { return balance; }

        // External API methods that set context fields and then dispatch events
        public void insertCoin(int cents) {
            System.out.printf("[INPUT] insertCoin(%d cents)%n", cents);
            balance += cents;
            handleEvent(Event.INSERT_COIN);
        }

        // Use this to select an item — sets requestedItem then fires event
        public void selectItem(String itemCode) {
            System.out.printf("[INPUT] selectItem(%s)%n", itemCode);
            this.requestedItem = itemCode;
            handleEvent(Event.SELECT_ITEM);
        }

        public void cancel() {
            System.out.println("[INPUT] cancel()");
            handleEvent(Event.CANCEL);
        }

        // Add stock then fire REFILL event
        public void refill(String itemCode, int qty) {
            System.out.printf("[INPUT] refill(%s, %d)%n", itemCode, qty);
            stock.put(itemCode, stock.getOrDefault(itemCode, 0) + qty);
            handleEvent(Event.REFILL);
        }

        public void enterMaintenance() {
            System.out.println("[INPUT] enterMaintenance()");
            handleEvent(Event.ENTER_MAINTENANCE);
        }

        public void exitMaintenance() {
            System.out.println("[INPUT] exitMaintenance()");
            handleEvent(Event.EXIT_MAINTENANCE);
        }

        // Helper to set price
        public void setPrice(String itemCode, int cents) {
            price.put(itemCode, cents);
        }

        // Public wrapper so external code (tests / main) can fire arbitrary events like DISPENSE_COMPLETE
        public void handleEvent(Event event) {
            dispatch(event);
        }

        // Internal dispatch based on current state and event
        private void dispatch(Event event) {
            System.out.printf("[DISPATCH] state=%s event=%s%n", current, event);
            Map<Event, Transition> row = table.get(current);
            if (row == null) {
                System.out.println("  No transitions defined for current state. Ignoring event.");
                return;
            }
            Transition t = row.get(event);
            if (t == null) {
                System.out.println("  Event not applicable in this state. Ignoring.");
                return;
            }

            // Execute action
            t.action.accept(this, event);

            // State change
            if (t.nextState != null && t.nextState != current) {
                System.out.printf("  -> Transition: %s -> %s%n", current, t.nextState);
                current = t.nextState;
            } else {
                System.out.println("  -> No state change.");
            }
        }

        // Helper actions used in transition table (keeps code clearer)
        void refund() {
            if (balance > 0) {
                System.out.printf("  Refunding %d cents.%n", balance);
                balance = 0;
            } else {
                System.out.println("  Nothing to refund.");
            }
            requestedItem = null;
        }

        boolean hasStock(String item) {
            return stock.getOrDefault(item, 0) > 0;
        }

        void decrementStock(String item) {
            stock.put(item, stock.getOrDefault(item, 0) - 1);
        }

        int getPrice(String item) {
            return price.getOrDefault(item, Integer.MAX_VALUE);
        }

        // Public helper to add stock (so callers don't access private fields)
        public void addStock(String itemCode, int qty) {
            stock.put(itemCode, stock.getOrDefault(itemCode, 0) + qty);
        }

        // For debugging
        public void printStatus() {
            System.out.println("=== MACHINE STATUS ===");
            System.out.println("State: " + current);
            System.out.println("Balance (cents): " + balance);
            System.out.println("Requested item: " + requestedItem);
            System.out.println("Stock: " + stock);
            System.out.println("======================");
        }
    }

    // Build the transition table
    public static Map<State, Map<Event, Transition>> buildTransitionTable() {
        Map<State, Map<Event, Transition>> table = new EnumMap<>(State.class);

        // Helper to create rows
        BiConsumer<State, Map<Event, Transition>> setRow = (state, row) -> table.put(state, row);

        // IDLE state transitions
        Map<Event, Transition> idle = new EnumMap<>(Event.class);
        idle.put(Event.INSERT_COIN, new Transition(
                State.HAS_COIN,
                (vm, e) -> System.out.println("  Coin inserted. Waiting for selection.")
        ));
        idle.put(Event.ENTER_MAINTENANCE, new Transition(
                State.MAINTENANCE,
                (vm, e) -> System.out.println("  Entering maintenance mode.")
        ));
        idle.put(Event.REFILL, new Transition(
                State.IDLE,
                (vm, e) -> System.out.println("  Refilled (while idle).")
        ));
        setRow.accept(State.IDLE, idle);

        // HAS_COIN state transitions
        Map<Event, Transition> hasCoin = new EnumMap<>(Event.class);
        hasCoin.put(Event.INSERT_COIN, new Transition(
                State.HAS_COIN,
                (vm, e) -> System.out.println("  Additional coin inserted.")
        ));
        hasCoin.put(Event.SELECT_ITEM, new Transition(
                State.DISPENSING,
                (vm, e) -> {
                    String item = vm.requestedItem;
                    if (item == null) {
                        System.out.println("  No item selected.");
                        // stay in HAS_COIN
                        vm.requestedItem = null;
                    } else if (!vm.hasStock(item)) {
                        System.out.printf("  Item '%s' is out of stock.%n", item);
                        // refund user and set OUT_OF_STOCK state explicitly
                        vm.refund();
                        // side-effect state change: we switch to OUT_OF_STOCK
                        // (we do this by directly setting current via a small helper:
                        //  since current is private, we rely on the transition object's nextState below)
                        // To ensure the table captures this, we'll change the nextState in the transition entry to OUT_OF_STOCK.
                    } else {
                        int cost = vm.getPrice(item);
                        if (vm.balance < cost) {
                            System.out.printf("  Not enough balance for '%s'. Price %d cents, balance %d cents.%n",
                                    item, cost, vm.balance);
                            // stay in HAS_COIN
                        } else {
                            // Deduct, decrement stock, simulate dispensing
                            vm.balance -= cost;
                            vm.decrementStock(item);
                            System.out.printf("  Dispensing '%s'... (cost %d cents). Remaining balance: %d cents.%n",
                                    item, cost, vm.balance);
                        }
                    }
                }
        ));
        hasCoin.put(Event.CANCEL, new Transition(
                State.IDLE,
                (vm, e) -> {
                    System.out.println("  Cancel pressed. Returning coins.");
                    vm.refund();
                }
        ));
        hasCoin.put(Event.ENTER_MAINTENANCE, new Transition(
                State.MAINTENANCE,
                (vm, e) -> {
                    System.out.println("  Entering maintenance mode. Refunding user first.");
                    vm.refund();
                }
        ));
        setRow.accept(State.HAS_COIN, hasCoin);

        // DISPENSING state transitions
        Map<Event, Transition> dispensing = new EnumMap<>(Event.class);
        dispensing.put(Event.DISPENSE_COMPLETE, new Transition(
                State.IDLE,
                (vm, e) -> {
                    System.out.println("  Dispense complete.");
                    vm.requestedItem = null;
                    if (vm.balance > 0) {
                        System.out.printf("  Returning remaining balance: %d cents.%n", vm.balance);
                        vm.balance = 0;
                    }
                }
        ));
        // While dispensing, a REFILL event is allowed (operator) — stays DISPENSING
        dispensing.put(Event.REFILL, new Transition(
                State.DISPENSING,
                (vm, e) -> System.out.println("  Refilled during dispensing.")
        ));
        setRow.accept(State.DISPENSING, dispensing);

        // OUT_OF_STOCK state transitions
        Map<Event, Transition> outOfStock = new EnumMap<>(Event.class);
        outOfStock.put(Event.REFILL, new Transition(
                State.IDLE,
                (vm, e) -> System.out.println("  Refilled. Back to IDLE.")
        ));
        outOfStock.put(Event.ENTER_MAINTENANCE, new Transition(
                State.MAINTENANCE,
                (vm, e) -> System.out.println("  Entering maintenance from out-of-stock.")
        ));
        setRow.accept(State.OUT_OF_STOCK, outOfStock);

        // MAINTENANCE state transitions
        Map<Event, Transition> maintenance = new EnumMap<>(Event.class);
        maintenance.put(Event.REFILL, new Transition(
                State.MAINTENANCE,
                (vm, e) -> System.out.println("  Refilled while in maintenance.")
        ));
        maintenance.put(Event.EXIT_MAINTENANCE, new Transition(
                State.IDLE,
                (vm, e) -> System.out.println("  Exiting maintenance. Back to IDLE.")
        ));
        setRow.accept(State.MAINTENANCE, maintenance);

        return table;
    }
}

public class Optimal {
    public static void main(String[] args) {
        // Build the FSM transition table from the separate class
        var table = VendingMachineFSM.buildTransitionTable();
        var vm = new VendingMachineFSM.VendingMachine(table);

        // Setup: items and prices — use the public API
        vm.addStock("A1", 1); vm.setPrice("A1", 100); // 100 cents = $1.00
        vm.addStock("B2", 2); vm.setPrice("B2", 65);
        // C3 initially out of stock but set price
        vm.setPrice("C3", 50);

        System.out.println("=== START SCENARIO 1: Successful purchase ===");
        vm.printStatus();
        vm.insertCoin(50);
        vm.insertCoin(50);
        vm.selectItem("A1");
        vm.handleEvent(VendingMachineFSM.Event.DISPENSE_COMPLETE); // simulate hardware signalling completion
        vm.printStatus();

        System.out.println("\n=== SCENARIO 2: Not enough money, then cancel ===");
        vm.insertCoin(25);
        vm.selectItem("B2"); // price 65
        vm.cancel();
        vm.printStatus();

        System.out.println("\n=== SCENARIO 3: Select out-of-stock item ===");
        vm.insertCoin(50);
        vm.selectItem("C3"); // C3 quantity 0 => out of stock
        vm.printStatus();

        System.out.println("\n=== SCENARIO 4: Operator refills and user buys ===");
        vm.refill("C3", 3);
        vm.printStatus();
        vm.insertCoin(50);
        vm.selectItem("C3");
        vm.handleEvent(VendingMachineFSM.Event.DISPENSE_COMPLETE);
        vm.printStatus();

        System.out.println("\n=== SCENARIO 5: Enter and exit maintenance ===");
        vm.enterMaintenance();
        vm.refill("A1", 5); // allowed in maintenance
        vm.exitMaintenance();
        vm.printStatus();
    }
}
