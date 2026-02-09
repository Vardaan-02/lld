package Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private static Map<PrototypeType, Prototype<?>> registry = new HashMap<>();

    public static void register(PrototypeType key, Prototype<?> prototype){
        registry.put(key, prototype);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getClone(PrototypeType key){
        return (T) registry.get(key).clone();
    }
}
