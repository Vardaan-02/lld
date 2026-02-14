package Behavioural.Strategy.payment.impl;

import Behavioural.Strategy.payment.PaymentStrategy;

public class UPIStraregy implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paid " + amount + " using UPI");
    }
}
