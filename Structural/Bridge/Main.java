package Structural.Bridge;

import Structural.Bridge.Gateway.impl.RazorpayGateway;
import Structural.Bridge.Gateway.impl.StripeGateway;
import Structural.Bridge.Payment.Payment;
import Structural.Bridge.Payment.impl.CardPayment;
import Structural.Bridge.Payment.impl.UPIPayment;

public class Main {
    public static void main(String[] args) {
        Payment payment = new CardPayment(new RazorpayGateway());
        payment.pay(1000);

        Payment payment2 = new UPIPayment(new StripeGateway());
        payment2.pay(500);
    }
}
