package Behavioural.ChainOfResponsibility;

import Behavioural.ChainOfResponsibility.cacheSystem.CacheLayer;
import Behavioural.ChainOfResponsibility.cacheSystem.impl.Database;
import Behavioural.ChainOfResponsibility.cacheSystem.impl.MemoryCache;
import Behavioural.ChainOfResponsibility.cacheSystem.impl.RedisCache;

public class Main {
    public static void main(String[] args) {

        CacheLayer memory = new MemoryCache();
        CacheLayer redis = new RedisCache();
        CacheLayer db = new Database();

        memory.setNext(redis).setNext(db);

        System.out.println(memory.get("C"));
        System.out.println(memory.get("C"));
        System.out.println(memory.get("B"));
        System.out.println(memory.get("B"));
        System.out.println(memory.get("A"));
    }
}
