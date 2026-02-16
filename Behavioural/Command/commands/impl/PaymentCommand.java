package Behavioural.Command.commands.impl;

import Behavioural.Command.commands.Command;
import Behavioural.Command.services.PaymentService;

public class PaymentCommand implements Command{
    PaymentService paymentService;
    int amount;

    public PaymentCommand(PaymentService paymentService, int amount){
        this.paymentService = paymentService;
        this.amount = amount;
    }

    public void execute(){
        paymentService.processPayment(amount);
    }
}
