package main.java.consumable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import main.java.entity.Point;

public class ConsumableFactory {

    public record SpawnResult(Point location, Consumable item) {}

    public static SpawnResult spawnRandomConsumable(List<Point> availableCells) {
        if (availableCells == null || availableCells.isEmpty()) return null;

        int index = ThreadLocalRandom.current().nextInt(availableCells.size());
        Point spawnLocation = availableCells.get(index);
        
        double chance = ThreadLocalRandom.current().nextDouble();
        Consumable item = chance > 0.9 ? new SpeedBoost() : new Apple();
        
        return new SpawnResult(spawnLocation, item);
    }

    public static Consumable createFromName(String name) {
        if ("SpeedBoost".equals(name)) return new SpeedBoost();
        return new Apple(); 
    }
}