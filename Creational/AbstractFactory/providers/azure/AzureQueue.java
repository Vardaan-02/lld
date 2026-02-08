package Creational.AbstractFactory.providers.azure;

import Creational.AbstractFactory.domain.queue.QueueService;

public class AzureQueue implements QueueService{
    public void send(String msg){
        System.out.println("Sent via Azure Queue Storage: " + msg);
    }
}
