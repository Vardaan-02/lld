import java.util.*;

interface Mediator {
    void register(Participant p);
    void send(String message, Participant from, String toName);
    void broadcast(String message, Participant from);
}

class Participant {
    private final String name;
    private final Mediator mediator;

    Participant(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.register(this);
    }

    String getName() { return name; }

    void send(String toName, String message) {
        mediator.send(message, this, toName);
    }

    void broadcast(String message) {
        mediator.broadcast(message, this);
    }

    void receive(String message, Participant from) {
        System.out.println(name + " received from " + from.getName() + ": " + message);
    }
}

class ConcreteMediator implements Mediator {
    private final Map<String, Participant> participants = new HashMap<>();

    public void register(Participant p) {
        participants.put(p.getName(), p);
    }

    public void send(String message, Participant from, String toName) {
        Participant to = participants.get(toName);
        if (to == null) {
            System.out.println(from.getName() + " -> " + toName + ": FAILED (not registered)");
            return;
        }
        System.out.println(from.getName() + " -> " + to.getName() + ": " + message);
        to.receive(message, from);
    }

    public void broadcast(String message, Participant from) {
        System.out.println(from.getName() + " broadcasts: " + message);
        for (Participant p : participants.values()) {
            if (!p.equals(from)) p.receive(message, from);
        }
    }
}

public class Optimal {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Participant alice = new Participant("Alice", mediator);
        Participant bob   = new Participant("Bob", mediator);
        Participant charlie = new Participant("Charlie", mediator);

        alice.send("Bob", "Hi Bob!");
        bob.send("Charlie", "Hey Charlie, lunch?");
        charlie.send("Dave", "Hello?"); 

        alice.broadcast("Playground closes at 5!");
    }
}
