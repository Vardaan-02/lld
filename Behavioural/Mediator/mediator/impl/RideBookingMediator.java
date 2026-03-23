package Behavioural.Mediator.mediator.impl;

import java.util.*;

import Behavioural.Mediator.entities.Driver;
import Behavioural.Mediator.entities.Rider;
import Behavioural.Mediator.mediator.RideMediator;

public class RideBookingMediator implements RideMediator {

    private List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void requestRide(Rider rider, double distance, double fare) {
        System.out.println("Mediator: Finding driver...");

        Driver assignedDriver = findAvailableDriver(distance, fare);

        if (assignedDriver == null) {
            System.out.println("No drivers available 😔, try increasing fare");
            return;
        }

        assignedDriver.notifyRideRequest(rider, distance, fare);
    }

    @Override
    public void acceptRide(Driver driver, Rider rider, double fare) {
        System.out.println("Mediator: Ride confirmed between "
            + rider.getName() + " and " + driver.getName());

        rider.notifyDriverAssigned(driver, fare);
    }

    private Driver findAvailableDriver(double distance, double fare) {
        double fdr = fare/distance;
        for (Driver d : drivers) {
            if (d.isAvailable(fdr)) return d;
        }
        return null;
    }
}
