package Creational.AbstractFactory.app;

import Creational.AbstractFactory.bootstrap.CloudFactoryInitializer;
import Creational.AbstractFactory.domain.factory.CloudProviderFactory;
import Creational.AbstractFactory.registry.CloudFactoryRegistry;
import Creational.AbstractFactory.registry.CloudProvider;

public class Main {
    public static void main(String[] args) {
        CloudFactoryRegistry registry = CloudFactoryInitializer.initialize();

        CloudProviderFactory factory = registry.get(CloudProvider.GCP);

        CloudApplication app = new CloudApplication(factory);
        app.run();
    }
}
