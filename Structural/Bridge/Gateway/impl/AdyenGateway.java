package Structural.Bridge.Gateway.impl;

import Structural.Bridge.Gateway.PaymentGateway;

public class AdyenGateway implements PaymentGateway{
    public void processPayment(int amount){
        System.out.println("Payment processing via Adyen of amount: " + amount);
    }
}
