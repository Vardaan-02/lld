package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class CreatedState implements OrderState{
    public void confirmOrder(Order order) {
        System.out.println("Order confirmed. Awaiting payment.");
        order.setState(new PaymentPendingState());
    }

    public void makePayment(Order order) {
        throw new IllegalStateException("Cannot pay before confirmation.");
    }

    public void shipOrder(Order order) {
        throw new IllegalStateException("Order not paid yet.");
    }

    public void deliverOrder(Order order) {
        throw new IllegalStateException("Order not shipped.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order cancelled.");
        order.setState(new CancelledState());
    }

    public String name() {
        return "CREATED";
    }
}
