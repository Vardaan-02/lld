interface Vehical{
    void start();
    void stop();
}

class Car implements Vehical{

    @Override
    public void start(){
        System.out.println("Car starts");
    }

    @Override
    public void stop(){
        System.out.println("Car Stops");
    }
}

class Bike implements Vehical{

    @Override
    public void start(){
        System.out.println("Bike starts");
    }

    @Override
    public void stop(){
        System.out.println("Bike Stops");
    }
}

class Truck implements Vehical{

    @Override
    public void start(){
        System.out.println("Truck starts");
    }

    @Override
    public void stop(){
        System.out.println("Truck Stops");
    }
}

public class Naive{
    public static void main(String args[]){
        System.out.println("Hello, World!");

        Vehical v1 = new Car();
        v1.start();
        v1.stop();
        Vehical v2 = new Bike();
        v2.start();
        v2.stop();
        Vehical v3 = new Truck(); 
        v3.start();
        v3.stop();
    }
}