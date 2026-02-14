package Behavioural.Observer.cacheSystem.observer;

import Behavioural.Observer.cacheSystem.CacheEvent;

public interface CacheObserver {
    public void invalidate(CacheEvent event);
}
