package Creational.AbstractFactory.providers.aws;

import Creational.AbstractFactory.domain.compute.ComputeService;

public class AWSCompute implements ComputeService{
    public void createInstance(){
        System.out.println("AWS EC2 instance created");
    }
}
