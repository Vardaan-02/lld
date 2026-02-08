package Creational.AbstractFactory.bootstrap;

import java.util.HashMap;
import java.util.Map;

import Creational.AbstractFactory.domain.factory.CloudProviderFactory;
import Creational.AbstractFactory.providers.aws.AWSFactory;
import Creational.AbstractFactory.providers.azure.AzureFactory;
import Creational.AbstractFactory.providers.gcp.GCPFactory;
import Creational.AbstractFactory.registry.CloudFactoryRegistry;
import Creational.AbstractFactory.registry.CloudProvider;

public class CloudFactoryInitializer {

    public static CloudFactoryRegistry initialize() {

        Map<CloudProvider, CloudProviderFactory> factories = new HashMap<>();

        factories.put(CloudProvider.AWS, new AWSFactory());
        factories.put(CloudProvider.AZURE, new AzureFactory());
        factories.put(CloudProvider.GCP, new GCPFactory());

        return new CloudFactoryRegistry(factories);
    }
}
