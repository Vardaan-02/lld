package Structural.Proxy;

import java.util.HashMap;
import java.util.Map;

import Structural.Proxy.service.Service;
import Structural.Proxy.service.impl.OrderService;
import Structural.Proxy.service.impl.UserService;

public class APIGateway implements Service{
    private Map<String, Service> routes = new HashMap<>();

    public APIGateway(){
        routes.put("/user", new UserService());
        routes.put("/order", new OrderService());
    }

    private boolean authenticate(String token){
        return token.equals("valid-token");
    }

    public void handleRequest(String request){
        String token = "valid-token";

        if (!authenticate(token)) {
            System.out.println("Authentication failed");
            return;
        }

        for (String path : routes.keySet()) {
            if (request.startsWith(path)) {
                System.out.println("Gateway routing request...");
                routes.get(path).handleRequest(request);
                return;
            }
        }

        System.out.println("404 Not Found");
    }
}
