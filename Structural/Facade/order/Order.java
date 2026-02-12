package Structural.Facade.order;

import Structural.Facade.delivery.Agent;

public class Order {
    String item;
    Agent deliveryAgent;

    public Order(String item, Agent deliveryAgent){
        this.item = item;
        this.deliveryAgent = deliveryAgent;
    }

    public String to_String(){
        return item + " " + deliveryAgent.id;
    }
}
