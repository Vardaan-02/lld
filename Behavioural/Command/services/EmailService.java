package Behavioural.Command.services;

public class EmailService{
    public void send(String to, String body){
        System.out.println("Message send to: " + to + "\nMessage: " + body);
    }
}
