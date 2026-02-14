package Behavioural.Observer.cacheSystem.observer.impl;

import Behavioural.Observer.cacheSystem.CacheEvent;
import Behavioural.Observer.cacheSystem.observer.CacheObserver;

public class RedisCacheNode implements CacheObserver{
    private final String nodeName;

    public RedisCacheNode(String nodeName) {
        this.nodeName = nodeName;
    }

    public void invalidate(CacheEvent event){
        System.out.println(nodeName + " invalidating key: " + event.getKey());
    }
}
