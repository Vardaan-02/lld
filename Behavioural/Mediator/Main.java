package Behavioural.Mediator;

import Behavioural.Mediator.entities.Driver;
import Behavioural.Mediator.entities.Rider;
import Behavioural.Mediator.mediator.impl.RideBookingMediator;

public class Main {
    public static void main(String[] args) {
        RideBookingMediator mediator = new RideBookingMediator();

        Driver d1 = new Driver("Raj", mediator, 1.8);
        Driver d2 = new Driver("Amit", mediator, 1.2);

        mediator.addDriver(d1);
        mediator.addDriver(d2);

        Rider r1 = new Rider("Vardaan", mediator);
        Rider r2 = new Rider("Ashish", mediator);

        r1.requestRide(100,130);
        r2.requestRide(90,150);
        r2.requestRide(90,180);
    }
}
