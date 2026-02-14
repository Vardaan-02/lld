package Behavioural.Strategy.payment.impl;

import Behavioural.Strategy.payment.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}
