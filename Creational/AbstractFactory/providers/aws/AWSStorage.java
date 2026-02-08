package Creational.AbstractFactory.providers.aws;

import Creational.AbstractFactory.domain.storage.StorageService;

public class AWSStorage implements StorageService{
    public void upload(String file){
        System.out.println("Uploaded to AWS S3: " + file);
    }
}
