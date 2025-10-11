import java.util.*;

class Person {
    private final String name;
    private final Map<String, Person> contacts = new HashMap<>();

    Person(String name) { this.name = name; }

    void addContact(Person p) { contacts.put(p.getName(), p); }

    String getName() { return name; }

    void sendTo(String toName, String message) {
        Person to = contacts.get(toName);
        if (to == null) {
            System.out.println(name + " -> " + toName + ": FAILED (no such contact)");
            return;
        }
        System.out.println(name + " -> " + to.getName() + ": " + message);
        to.receive(message, this);
    }

    void receive(String message, Person from) {
        System.out.println(getName() + " received from " + from.getName() + ": " + message);
    }
}

public class Naive {
    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob   = new Person("Bob");
        Person charlie = new Person("Charlie");

        alice.addContact(bob);
        alice.addContact(charlie);

        bob.addContact(alice);
        bob.addContact(charlie);

        charlie.addContact(alice);
        charlie.addContact(bob);

        alice.sendTo("Bob", "Hi Bob!");
        bob.sendTo("Charlie", "Hey Charlie, lunch?");
        charlie.sendTo("Dave", "Hello?"); 

        // Problem: if a new Person "Dave" arrives, every person who wants to message Dave must addContact(dave).
    }
}
