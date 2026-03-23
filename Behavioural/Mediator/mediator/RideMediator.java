package Behavioural.Mediator.mediator;

import Behavioural.Mediator.entities.Driver;
import Behavioural.Mediator.entities.Rider;

public interface RideMediator {
    void requestRide(Rider rider, double distance, double fare);
    void acceptRide(Driver driver, Rider rider, double fare);
}