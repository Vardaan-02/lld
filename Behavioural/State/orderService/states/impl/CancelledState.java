package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class CancelledState implements OrderState{

    public void confirmOrder(Order order) {
        throw new IllegalStateException("Order cancelled.");
    }

    public void makePayment(Order order) {
        throw new IllegalStateException("Order cancelled.");
    }

    public void shipOrder(Order order) {
        throw new IllegalStateException("Order cancelled.");
    }

    public void deliverOrder(Order order) {
        throw new IllegalStateException("Order cancelled.");
    }

    public void cancelOrder(Order order) {
        throw new IllegalStateException("Already cancelled.");
    }

    public String name() {
        return "CANCELLED";
    }
}
