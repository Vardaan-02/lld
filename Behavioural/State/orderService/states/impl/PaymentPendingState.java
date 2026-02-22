package Behavioural.State.orderService.states.impl;

import Behavioural.State.orderService.Order;
import Behavioural.State.orderService.states.OrderState;

public class PaymentPendingState implements OrderState {

    public void confirmOrder(Order order) {
        throw new IllegalStateException("Already confirmed.");
    }

    public void makePayment(Order order) {
        System.out.println("Payment successful.");
        order.setState(new PaidState());
    }

    public void shipOrder(Order order) {
        throw new IllegalStateException("Payment not completed.");
    }

    public void deliverOrder(Order order) {
        throw new IllegalStateException("Order not shipped.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order cancelled during payment.");
        order.setState(new CancelledState());
    }

    public String name() {
        return "PAYMENT_PENDING";
    }
}
