package Creational.AbstractFactory.providers.gcp;

import Creational.AbstractFactory.domain.compute.ComputeService;
import Creational.AbstractFactory.domain.factory.CloudProviderFactory;
import Creational.AbstractFactory.domain.queue.QueueService;
import Creational.AbstractFactory.domain.storage.StorageService;

public class GCPFactory implements CloudProviderFactory{
    public ComputeService compute(){
        return new GCPCompute();
    }

    public QueueService queue(){
        return new GCPQueue();
    }

    public StorageService storage(){
        return new GCPStorage();
    }
}
