package Structural.Facade;

public class Main {

    public static void main(String[] args){
        OrderFacade f = new OrderFacade();

        f.placeOrder("Book", 100, "BH-1 318");
    }
}
