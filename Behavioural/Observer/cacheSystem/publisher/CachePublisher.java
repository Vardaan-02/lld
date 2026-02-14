package Behavioural.Observer.cacheSystem.publisher;

import Behavioural.Observer.cacheSystem.CacheEvent;
import Behavioural.Observer.cacheSystem.observer.CacheObserver;

public interface CachePublisher {
    public void subscribe(CacheObserver observer);
    public void unsubscribe(CacheObserver observer);
    public void publish(CacheEvent event);
}
