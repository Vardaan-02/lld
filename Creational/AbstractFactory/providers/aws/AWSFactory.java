package Creational.AbstractFactory.providers.aws;

import Creational.AbstractFactory.domain.compute.ComputeService;
import Creational.AbstractFactory.domain.factory.CloudProviderFactory;
import Creational.AbstractFactory.domain.queue.QueueService;
import Creational.AbstractFactory.domain.storage.StorageService;

public class AWSFactory implements CloudProviderFactory{
    public ComputeService compute(){
        return new AWSCompute();
    }

    public QueueService queue(){
        return new AWSQueue();
    }

    public StorageService storage(){
        return new AWSStorage();
    }
}
