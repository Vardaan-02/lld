package Structural.Facade.service;

public class PaymentService {
    public void charge(int amount){
        System.out.println("Transaction of amount: " + amount + " -> Successfull");
    }
}
