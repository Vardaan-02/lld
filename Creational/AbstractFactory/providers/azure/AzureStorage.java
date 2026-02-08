package Creational.AbstractFactory.providers.azure;

import Creational.AbstractFactory.domain.storage.StorageService;

public class AzureStorage implements StorageService{
    public void upload(String file){
        System.out.println("Uploaded to Azure Blob Storage: " + file);
    }
}
