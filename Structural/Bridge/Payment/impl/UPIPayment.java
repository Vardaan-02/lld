package Structural.Bridge.Payment.impl;

import Structural.Bridge.Gateway.PaymentGateway;
import Structural.Bridge.Payment.Payment;

public class UPIPayment extends Payment{
    public UPIPayment(PaymentGateway gateway){
        super(gateway);
    }

    public void pay(int amount){
        System.out.println("Card payment initiated");
        gateway.processPayment(amount);
    }
}
