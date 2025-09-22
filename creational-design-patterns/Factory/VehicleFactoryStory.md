# 🚗 Vehicle Factory Story — From Naive to Abstract Factory

This README explains **Factory Design Pattern** and **Abstract Factory Design Pattern** in the simplest way, step by step, with code examples.  
We’ll go from the **naive approach** → **Factory** → **Abstract Factory**.  
All explained in a story format, as if you’re **5 years old**.  

---

## 🏁 1. The Naive Beginning

Imagine you are playing with toy vehicles: **Car**, **Bike**, and **Truck**.  
You want to make them start and stop.

```java
class Car {
    public void start() { System.out.println("Car starts"); }
    public void stop()  { System.out.println("Car stops"); }
}

class Bike {
    public void start() { System.out.println("Bike starts"); }
    public void stop()  { System.out.println("Bike stops"); }
}

class Truck {
    public void start() { System.out.println("Truck starts"); }
    public void stop()  { System.out.println("Truck stops"); }
}

public class Naive {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();

        Bike bike = new Bike();
        bike.start();
        bike.stop();

        Truck truck = new Truck();
        truck.start();
        truck.stop();
    }
}
```

👎 Problem: Every time we want a new type of Vehicle, we must **change our main code**. Not flexible!

---

## 🏭 2. The Factory Design Pattern

A **Factory** is like a **toy shop**.  
Instead of making cars, bikes, and trucks ourselves, we **ask the shop**: “Give me a Car!”

### Step 1: Create a common interface
```java
interface Vehicle {
    void start();
    void stop();
}
```

### Step 2: Make all vehicles follow this interface
```java
class Car implements Vehicle {
    public void start() { System.out.println("Car starts"); }
    public void stop()  { System.out.println("Car stops"); }
}

class Bike implements Vehicle {
    public void start() { System.out.println("Bike starts"); }
    public void stop()  { System.out.println("Bike stops"); }
}

class Truck implements Vehicle {
    public void start() { System.out.println("Truck starts"); }
    public void stop()  { System.out.println("Truck stops"); }
}
```

### Step 3: Create a Factory (the shop)
```java
class Factory {
    public static Vehicle getVehicle(String type) {
        if (type.equals("Car")) return new Car();
        else if (type.equals("Bike")) return new Bike();
        else if (type.equals("Truck")) return new Truck();
        else throw new IllegalArgumentException("Unknown type");
    }
}
```

### Step 4: Use it
```java
public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle v1 = Factory.getVehicle("Car");
        v1.start();
        v1.stop();

        Vehicle v2 = Factory.getVehicle("Bike");
        v2.start();
        v2.stop();
    }
}
```

✅ Advantage: We **don’t change main code** when new vehicles come, only update Factory.

---

## 🧰 3. Improving Factory with `Supplier`

We can make our factory **smarter** using Java’s `Supplier<T>` functional interface.

- `Supplier<Vehicle>` = a recipe to make a Vehicle whenever needed.

```java
import java.util.*;
import java.util.function.Supplier;

class Factory {
    private static final Map<String, Supplier<Vehicle>> registry = new HashMap<>();
    static {
        registry.put("Car", Car::new);
        registry.put("Bike", Bike::new);
        registry.put("Truck", Truck::new);
    }

    public static Vehicle getVehicle(String type) {
        Supplier<Vehicle> supplier = registry.get(type);
        if (supplier != null) return supplier.get();
        throw new IllegalArgumentException("Unknown type");
    }
}
```

🎉 Now adding a new Vehicle = just register it in the map, no if-else needed.

---

## 🏢 4. Abstract Factory Design Pattern

Now imagine you have **two shops**:  
- One makes **Regular Vehicles** (Car, Bike, Truck).  
- Another makes **Luxury Vehicles** (LuxuryCar, LuxuryBike).  

We need a **factory of factories** → Abstract Factory.

### Step 1: Abstract Factory interface
```java
interface VehicleFactory {
    Vehicle createCar();
    Vehicle createBike();
}
```

### Step 2: Implement factories
```java
class RegularVehicleFactory implements VehicleFactory {
    public Vehicle createCar() { return new Car(); }
    public Vehicle createBike() { return new Bike(); }
}

class LuxuryVehicleFactory implements VehicleFactory {
    public Vehicle createCar() { return new LuxuryCar(); }
    public Vehicle createBike() { return new LuxuryBike(); }
}
```

### Step 3: Vehicle types
```java
class LuxuryCar implements Vehicle {
    public void start() { System.out.println("Luxury Car starts smoothly"); }
    public void stop()  { System.out.println("Luxury Car stops smoothly"); }
}

class LuxuryBike implements Vehicle {
    public void start() { System.out.println("Luxury Bike starts smoothly"); }
    public void stop()  { System.out.println("Luxury Bike stops smoothly"); }
}
```

### Step 4: Use Abstract Factory
```java
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory factory;

        // Choose which shop to use
        factory = new RegularVehicleFactory();
        Vehicle car = factory.createCar();
        car.start();

        factory = new LuxuryVehicleFactory();
        Vehicle luxuryCar = factory.createCar();
        luxuryCar.start();
    }
}
```

---

## 🎯 Summary

- **Naive approach** → Make vehicles directly. Hard to extend.  
- **Factory Pattern** → Central shop that makes vehicles. Easy to extend.  
- **Supplier-based Factory** → Even cleaner, uses Java’s functional programming.  
- **Abstract Factory Pattern** → A factory of factories, useful when you need multiple families of related products (e.g., Regular vs Luxury).  

---

## 🧒 Story Analogy

- Naive: You build toys at home by yourself (tiring).  
- Factory: You go to a toy shop and buy toys.  
- Abstract Factory: There are **different toy shops** (one for regular, one for luxury), and you choose which shop to visit.  

---

✨ Now you understand how factories in code are just like **toy shops in real life**!
