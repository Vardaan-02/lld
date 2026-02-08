package Creational.AbstractFactory.domain.factory;

import Creational.AbstractFactory.domain.compute.ComputeService;
import Creational.AbstractFactory.domain.queue.QueueService;
import Creational.AbstractFactory.domain.storage.StorageService;

public interface CloudProviderFactory {
    public ComputeService compute();
    public QueueService queue();
    public StorageService storage();
}
