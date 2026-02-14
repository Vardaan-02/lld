package Behavioural.Strategy.payment;

public class CheckoutService {
    PaymentStrategy paymentStrategy;

    public CheckoutService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public CheckoutService(){}

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        paymentStrategy.pay(amount);
    }
}
