package Structural.Bridge.Payment;

import Structural.Bridge.Gateway.PaymentGateway;

public abstract class Payment {
    protected PaymentGateway gateway;

    public Payment(PaymentGateway gateway){
        this.gateway = gateway;
    }

    abstract public void pay(int amount);
}
