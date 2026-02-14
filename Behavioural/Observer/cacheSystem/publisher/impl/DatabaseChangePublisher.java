package Behavioural.Observer.cacheSystem.publisher.impl;

import java.util.List;
import java.util.ArrayList;

import Behavioural.Observer.cacheSystem.CacheEvent;
import Behavioural.Observer.cacheSystem.observer.CacheObserver;
import Behavioural.Observer.cacheSystem.publisher.CachePublisher;

public class DatabaseChangePublisher implements CachePublisher{
    private final List<CacheObserver> observers = new ArrayList<>();

    public void subscribe(CacheObserver cacheObserver){
        observers.add(cacheObserver);
    }

    public void unsubscribe(CacheObserver cacheObserver){
        observers.remove(cacheObserver);
    }

    public void publish(CacheEvent cacheEvent){
        for (CacheObserver observer : observers){
            observer.invalidate(cacheEvent);
        }
    }

    public void updateData(String key) {
        System.out.println("DB updated for key: " + key);
        publish(new CacheEvent(key));
    }
}
