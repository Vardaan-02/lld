package Creational.AbstractFactory.providers.gcp;

import Creational.AbstractFactory.domain.storage.StorageService;

public class GCPStorage implements StorageService{
    public void upload(String file){
        System.out.println("Uploaded to Google Cloud Storage (GCS): " + file);
    }
}
