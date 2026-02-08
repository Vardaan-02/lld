package Creational.AbstractFactory.providers.azure;

import Creational.AbstractFactory.domain.compute.ComputeService;
import Creational.AbstractFactory.domain.factory.CloudProviderFactory;
import Creational.AbstractFactory.domain.queue.QueueService;
import Creational.AbstractFactory.domain.storage.StorageService;

public class AzureFactory implements CloudProviderFactory{
    public ComputeService compute(){
        return new AzureCompute();
    }

    public QueueService queue(){
        return new AzureQueue();
    }

    public StorageService storage(){
        return new AzureStorage();
    }
}
