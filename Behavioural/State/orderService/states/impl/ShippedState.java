package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class ShippedState implements OrderState {

    public void confirmOrder(Order order) {
        throw new IllegalStateException("Already shipped.");
    }

    public void makePayment(Order order) {
        throw new IllegalStateException("Already paid.");
    }

    public void shipOrder(Order order) {
        throw new IllegalStateException("Already shipped.");
    }

    public void deliverOrder(Order order) {
        System.out.println("Order delivered.");
        order.setState(new DeliveredState());
    }

    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel after shipping.");
    }

    public String name() {
        return "SHIPPED";
    }
}
