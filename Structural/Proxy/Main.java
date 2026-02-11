package Structural.Proxy;

import Structural.Proxy.service.Service;

public class Main {
    public static void main(String[] args) {

        Service gateway = new APIGateway();

        gateway.handleRequest("/user/getProfile");
        gateway.handleRequest("/order/create");
    }
}
