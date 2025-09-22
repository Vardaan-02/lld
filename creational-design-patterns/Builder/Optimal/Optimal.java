abstract class Vehicle {
    String engine;
    int wheels;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " { engine='" + engine + "', wheels=" + wheels + " }";
    }
}

abstract class VehicleBuilder<T extends VehicleBuilder<T, V>, V extends Vehicle> {
    protected V v;

    public T engine(String s) {
        v.engine = s;
        return self();
    }

    public T wheels(int n) {
        v.wheels = n;
        return self();
    }

    protected abstract T self();

    public V build() {
        return v;  
    }
}

class Car extends Vehicle {}

class CarBuilder extends VehicleBuilder<CarBuilder, Car> {
    public CarBuilder() {
        v = new Car();
    }

    @Override
    protected CarBuilder self() {
        return this;
    }
}

class Bike extends Vehicle {}

class BikeBuilder extends VehicleBuilder<BikeBuilder, Bike> {
    public BikeBuilder() {
        v = new Bike();
    }

    @Override
    protected BikeBuilder self() {
        return this;
    }
}

public class Optimal {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .engine("V8")
                .wheels(4)
                .build(); 

        Bike bike = new BikeBuilder()
                .engine("200cc")
                .wheels(2)
                .build(); 

        System.out.println(car);
        System.out.println(bike);
    }
}
