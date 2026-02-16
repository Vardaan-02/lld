package Behavioural.ChainOfResponsibility.cacheSystem.impl;

import java.util.HashMap;
import java.util.Map;

import Behavioural.ChainOfResponsibility.cacheSystem.CacheLayer;

public class MemoryCache extends CacheLayer{
    private Map<String, String> cache = new HashMap<>();

    public MemoryCache() {
        cache.put("A","Memory Value A");
    }

    public String get(String key){
        if (cache.containsKey(key)){
            System.out.println("MemoryCache HIT");
            return cache.get(key);
        }

        System.out.println("MemoryCache MISS");

        if (next_handler != null){
            String value = next_handler.get(key);
            if(value != null) cache.put(key, value); 
            return value;
        }

        return null;
    }

    public void put(String key, String value){
        cache.put(key, value);
    }
}
