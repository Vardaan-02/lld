package Behavioural.State;

import Behavioural.State.orderService.Order;

public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.confirmOrder();
        order.makePayment();
        order.shipOrder();
        order.deliverOrder();

        System.out.println("Final Status: " + order.getStatus());
    }
}
