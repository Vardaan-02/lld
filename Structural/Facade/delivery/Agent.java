package Structural.Facade.delivery;

public class Agent {
    public int id;

    public Agent(int id){
        this.id = id;
    }

    public Agent(int id, String location){
        this.id = id;
        System.out.println("Delivery scheduled to location: " + location);
    }

    public void deliver(String location){
        System.out.println("Delivery scheduled to location: " + location);
    }
}
