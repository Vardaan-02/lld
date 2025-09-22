interface Vehicle {
    void start();
    void stop();
}

interface TwoWheeler extends Vehicle {}
interface FourWheeler extends Vehicle {}

class Bike implements TwoWheeler {
    public void start() { System.out.println("Bike starts"); }
    public void stop() { System.out.println("Bike stops"); }
}
class DirtBike implements TwoWheeler {
    public void start() { System.out.println("DirtBike starts"); }
    public void stop() { System.out.println("DirtBike stops"); }
}
class Car implements FourWheeler {
    public void start() { System.out.println("Car starts"); }
    public void stop() { System.out.println("Car stops"); }
}
class Truck implements FourWheeler {
    public void start() { System.out.println("Truck starts"); }
    public void stop() { System.out.println("Truck stops"); }
}

interface VehicleFactory {
    TwoWheeler createTwoWheeler();
    FourWheeler createFourWheeler();
}

class LightVehicleFactory implements VehicleFactory {
    public TwoWheeler createTwoWheeler() { return new Bike(); }
    public FourWheeler createFourWheeler() { return new Car(); }
}
class HeavyVehicleFactory implements VehicleFactory {
    public TwoWheeler createTwoWheeler() { return new DirtBike(); }
    public FourWheeler createFourWheeler() { return new Truck(); }
}

public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactory light = new LightVehicleFactory();
        VehicleFactory heavy = new HeavyVehicleFactory();

        light.createTwoWheeler().start();
        light.createFourWheeler().start();
        heavy.createTwoWheeler().start();
        heavy.createFourWheeler().start();
    }
}
