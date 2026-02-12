package Structural.Bridge.Gateway.impl;

import Structural.Bridge.Gateway.PaymentGateway;

public class RazorpayGateway implements PaymentGateway{
    public void processPayment(int amount){
        System.out.println("Payment processing via Razorpay of amount: " + amount);
    }
}
