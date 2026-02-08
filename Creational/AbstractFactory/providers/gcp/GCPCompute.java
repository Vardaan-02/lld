package Creational.AbstractFactory.providers.gcp;

import Creational.AbstractFactory.domain.compute.ComputeService;

public class GCPCompute implements ComputeService{
    public void createInstance(){
        System.out.println("Google Compute Engine (GCE) created");
    }
}
