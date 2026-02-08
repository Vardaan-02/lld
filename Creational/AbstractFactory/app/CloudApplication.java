package Creational.AbstractFactory.app;

import Creational.AbstractFactory.domain.factory.CloudProviderFactory;

public class CloudApplication {

    private final CloudProviderFactory factory;

    public CloudApplication(CloudProviderFactory factory) {
        this.factory = factory;
    }

    public void run() {
        factory.compute().createInstance();
        factory.storage().upload("file.txt");
        factory.queue().send("hello");
    }
}
