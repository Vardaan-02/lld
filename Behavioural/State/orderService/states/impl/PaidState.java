package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class PaidState implements OrderState {

    public void confirmOrder(Order order) {
        throw new IllegalStateException("Already paid.");
    }

    public void makePayment(Order order) {
        throw new IllegalStateException("Already paid.");
    }

    public void shipOrder(Order order) {
        System.out.println("Order shipped.");
        order.setState(new ShippedState());
    }

    public void deliverOrder(Order order) {
        throw new IllegalStateException("Not shipped yet.");
    }

    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel after payment.");
    }

    public String name() {
        return "PAID";
    }
}
