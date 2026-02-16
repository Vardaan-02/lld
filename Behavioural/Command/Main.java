package Behavioural.Command;

import java.util.ArrayList;
import java.util.List;

import Behavioural.Command.commands.Command;
import Behavioural.Command.commands.impl.EmailCommand;
import Behavioural.Command.commands.impl.PaymentCommand;
import Behavioural.Command.services.EmailService;
import Behavioural.Command.services.PaymentService;

public class Main {
    public static void main(String args[]){
        EmailService emailService = new EmailService();
        PaymentService paymentService = new PaymentService();
        
        List<Command> commands= new ArrayList<>();
        commands.add(new EmailCommand(emailService, "Vardaan", "systUm"));
        commands.add(new PaymentCommand(paymentService, 300));
        commands.add(new PaymentCommand(paymentService, 500));
        commands.add(new EmailCommand(emailService, "Vardaan", "systUm02"));
        commands.add(new PaymentCommand(paymentService, 90));
        
        Worker w = new Worker();

        for (Command command : commands){
            w.process(command);
        }
    }   
}
