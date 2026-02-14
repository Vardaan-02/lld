package Behavioural.Strategy;

import Behavioural.Strategy.payment.CheckoutService;
import Behavioural.Strategy.payment.impl.CreditCardStrategy;
import Behavioural.Strategy.payment.impl.UPIStraregy;

public class Main {
    public static void main(String[] args) {

        CheckoutService service = new CheckoutService();

        service.setStrategy(new CreditCardStrategy());
        service.checkout(1000);

        service.setStrategy(new UPIStraregy());
        service.checkout(500);
    }
}
