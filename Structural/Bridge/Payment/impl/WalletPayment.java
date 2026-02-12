package Structural.Bridge.Payment.impl;

import Structural.Bridge.Gateway.PaymentGateway;
import Structural.Bridge.Payment.Payment;

class WalletPayment extends Payment {

    WalletPayment(PaymentGateway gateway) {
        super(gateway);
    }

    public void pay(int amount) {
        System.out.println("Wallet payment initiated");
        gateway.processPayment(amount);
    }
}
