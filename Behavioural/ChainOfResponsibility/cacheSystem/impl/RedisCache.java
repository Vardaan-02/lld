package Behavioural.ChainOfResponsibility.cacheSystem.impl;

import java.util.HashMap;
import java.util.Map;

import Behavioural.ChainOfResponsibility.cacheSystem.CacheLayer;

public class RedisCache extends CacheLayer{
    private Map<String, String> cache = new HashMap<>();

    public RedisCache() {
        cache.put("B","Redis Value B");
    }
    
    public String get(String key){
        if (cache.containsKey(key)){
            System.out.println("RedisCache HIT");
            return cache.get(key);
        }

        System.out.println("RedisCache MISS");

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
