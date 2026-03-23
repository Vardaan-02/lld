package Behavioural.Mediator.entities;

import Behavioural.Mediator.mediator.RideMediator;

public class Rider {
    private String name;
    private RideMediator mediator;

    public Rider(String name, RideMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return this.name;
    }

    public void requestRide(int distance, double fare) {
        System.out.println(name + " is requesting ride for distance " + distance + " with fare " + fare);
        mediator.requestRide(this, distance, fare);
    }

    public void notifyDriverAssigned(Driver driver, double fare) {
        System.out.println("Rider " + name + " got driver "
                + driver.getName() + " with fare " + fare);
    }
}
