package Creational.AbstractFactory.registry;

import java.util.Map;

import Creational.AbstractFactory.domain.factory.CloudProviderFactory;

public class CloudFactoryRegistry {
    private final Map<CloudProvider, CloudProviderFactory> factories;

    public CloudFactoryRegistry(Map<CloudProvider, CloudProviderFactory> factories) {
        this.factories = factories;
    }

    public CloudProviderFactory get(CloudProvider provider) {
        return factories.get(provider);
    }
}