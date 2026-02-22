package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class DeliveredState implements OrderState {

    public void confirmOrder(Order order) {
        throw new IllegalStateException("Already completed.");
    }

    public void makePayment(Order order) {
        throw new IllegalStateException("Already completed.");
    }

    public void shipOrder(Order order) {
        throw new IllegalStateException("Already completed.");
    }

    public void deliverOrder(Order order) {
        throw new IllegalStateException("Already delivered.");
    }

    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel completed order.");
    }

    public String name() {
        return "DELIVERED";
    }
}
