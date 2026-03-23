package Behavioural.Mediator.entities;

import Behavioural.Mediator.mediator.RideMediator;

public class Driver {
    private String name;
    private RideMediator mediator;
    private boolean available = true;
    private double fareToDistanceRatio;

    public Driver(String name, RideMediator mediator, double fareToDistanceRatio){
        this.name = name;
        this.mediator = mediator;
        this.fareToDistanceRatio = fareToDistanceRatio;
    }

    public String getName(){
        return this.name;
    }

    public boolean isAvailable(double dfr) {
        if (dfr > this.fareToDistanceRatio) return available;
        else return false;
    }

    public void acceptRide(Rider rider, double fare) {
        available = false;
        mediator.acceptRide(this, rider, fare);
    }

    public void notifyRideRequest(Rider rider, double distance, double fare) {
        System.out.println("Driver " + name + " received request for "
            + rider.getName() + " | Fare: " + fare + " | Distance: " + distance);
        
        acceptRide(rider, this.fareToDistanceRatio * distance);
    }
}
