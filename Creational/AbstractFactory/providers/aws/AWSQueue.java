package Creational.AbstractFactory.providers.aws;

import Creational.AbstractFactory.domain.queue.QueueService;

public class AWSQueue implements QueueService{
    public void send(String msg){
        System.out.println("Sent via AWS SQS: " + msg);
    }
}
