interface Vehicle{
    void start();
    void stop();
}

class Car implements Vehicle{

    @Override
    public void start(){
        System.out.println("Car starts");
    }

    @Override
    public void stop(){
        System.out.println("Car Stops");
    }
}

class Bike implements Vehicle{

    @Override
    public void start(){
        System.out.println("Bike starts");
    }

    @Override
    public void stop(){
        System.out.println("Bike Stops");
    }
}

class Truck implements Vehicle{

    @Override
    public void start(){
        System.out.println("Truck starts");
    }

    @Override
    public void stop(){
        System.out.println("Truck Stops");
    }
}

class Factory {

    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } 
        else if (vehicleType.equalsIgnoreCase("Truck")) {
            return new Truck();
        } 
        else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
    
}

public class Suboptimal{
    public static void main(String args[]){
        System.out.println("Hello, World!");

        Vehicle v1 = Factory.getVehicle("Car");
        v1.start();
        v1.stop();
        Vehicle v2 = Factory.getVehicle("Bike");
        v2.start();
        v2.stop();
        Vehicle v3 = Factory.getVehicle("Truck");
        v3.start();
        v3.stop();
    }
}