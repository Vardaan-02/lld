package Creational.AbstractFactory.providers.azure;

import Creational.AbstractFactory.domain.compute.ComputeService;

public class AzureCompute implements ComputeService{
    public void createInstance(){
        System.out.println("Azure Virtual Machine (VM) created");
    }
}
