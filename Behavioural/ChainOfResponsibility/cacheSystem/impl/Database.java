package Behavioural.ChainOfResponsibility.cacheSystem.impl;

import java.util.HashMap;
import java.util.Map;

import Behavioural.ChainOfResponsibility.cacheSystem.CacheLayer;

public class Database extends CacheLayer{
    private Map<String, String> cache = new HashMap<>();

    public Database() {
        cache.put("C","DB Value C");
    }

    public String get(String key){
        if (cache.containsKey(key)){
            System.out.println("Database HIT");
            return cache.get(key);
        }

        System.out.println("Database MISS");

        return null;
    }

    public void put(String key, String value){
        cache.put(key, value);
    }
}
