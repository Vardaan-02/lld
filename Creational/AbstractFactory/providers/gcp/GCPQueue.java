package Creational.AbstractFactory.providers.gcp;

import Creational.AbstractFactory.domain.queue.QueueService;

public class GCPQueue implements QueueService{
    public void send(String msg){
        System.out.println("Send via Cloud Pub/Sub (Publish/Subscribe): " + msg);
    }
}
