import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() { System.out.println("Car starts"); }
    @Override
    public void stop() { System.out.println("Car stops"); }
}

class Bike implements Vehicle {
    @Override
    public void start() { System.out.println("Bike starts"); }
    @Override
    public void stop() { System.out.println("Bike stops"); }
}

class Truck implements Vehicle {
    @Override
    public void start() { System.out.println("Truck starts"); }
    @Override
    public void stop() { System.out.println("Truck stops"); }
}


class VehicleFactory {
    private static final Map<String, Supplier<Vehicle>> registry = new HashMap<>();

    static {
        registry.put("Car", Car::new);
        registry.put("Bike", Bike::new);
        registry.put("Truck", Truck::new);
    }

    public static void registerVehicle(String name, Supplier<Vehicle> supplier) {
        registry.put(name, supplier);
    }

    public static Vehicle getVehicle(String type) {
        Supplier<Vehicle> supplier = registry.get(type);

        if (supplier != null) { return supplier.get(); }
        else throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }
}

public class Optimal {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.getVehicle("Car");
        v1.start();
        v1.stop();

        Vehicle v2 = VehicleFactory.getVehicle("Bike");
        v2.start();
        v2.stop();

        VehicleFactory.registerVehicle("Bus", () -> new Vehicle() {
            @Override
            public void start() { System.out.println("Bus starts"); }
            @Override
            public void stop() { System.out.println("Bus stops"); }
            public void h(){ System.out.println("Checking" ); } 
        });

        Vehicle v3 = VehicleFactory.getVehicle("Bus");
        v3.start();
        v3.stop();
    }
}
