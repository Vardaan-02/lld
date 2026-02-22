package Behavioural.State.orderService.states;

import Behavioural.State.orderService.Order;

public interface OrderState {
    public void confirmOrder(Order order);
    public void makePayment(Order order);
    public void shipOrder(Order order);
    public void deliverOrder(Order order);
    public void cancelOrder(Order order);

    String name();
}
