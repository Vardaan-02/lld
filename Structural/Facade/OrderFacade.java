package Structural.Facade;

import Structural.Facade.delivery.Agent;
import Structural.Facade.order.Order;
import Structural.Facade.service.InventoryService;
import Structural.Facade.service.NotificationService;
import Structural.Facade.service.PaymentService;

public class OrderFacade {
    InventoryService inventory;
    PaymentService payment;
    Agent delivery;
    NotificationService notification;

    public OrderFacade(){
        inventory = new InventoryService();
        payment = new PaymentService();
        notification = new NotificationService();
    }

    public Order placeOrder(String item, int amount, String location) {

        inventory.reserve(item);

        payment.charge(amount);

        Agent agent = new Agent(1, location);

        notification.notify(item);

        return new Order(item, agent);
    }
}
