package Structural.Bridge.Gateway.impl;

import Structural.Bridge.Gateway.PaymentGateway;

public class StripeGateway implements PaymentGateway{
    public void processPayment(int amount){
        System.out.println("Payment processing via Stripe of amount: " + amount);
    }
}
