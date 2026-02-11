package Structural.Proxy.service.impl;

import Structural.Proxy.service.Service;

public class OrderService implements Service{
    public void handleRequest(String request){
        System.out.println("OrderService handling: " + request);
    }
}
