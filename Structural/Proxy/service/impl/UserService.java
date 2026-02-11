package Structural.Proxy.service.impl;

import Structural.Proxy.service.Service;

public class UserService implements Service {

    public void handleRequest(String request) {
        System.out.println("UserService handling: " + request);
    }
}
