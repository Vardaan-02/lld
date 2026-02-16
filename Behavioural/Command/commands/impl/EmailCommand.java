package Behavioural.Command.commands.impl;

import Behavioural.Command.commands.Command;
import Behavioural.Command.services.EmailService;

public class EmailCommand implements Command{
    private EmailService emailService;
    String to;
    String body;

    public EmailCommand(EmailService emailService, String to, String body){
        this.emailService = emailService;
        this.to = to;
        this.body = body;

    }

    public void execute(){
        emailService.send(to, body);
    }
}
