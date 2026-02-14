package Behavioural.Observer;

import Behavioural.Observer.cacheSystem.observer.CacheObserver;
import Behavioural.Observer.cacheSystem.observer.impl.RedisCacheNode;
import Behavioural.Observer.cacheSystem.publisher.impl.DatabaseChangePublisher;

public class Main {
    public static void main(String[] args) {

        DatabaseChangePublisher publisher = new DatabaseChangePublisher();

        CacheObserver cache1 = new RedisCacheNode("Redis-Node-1");
        CacheObserver cache2 = new RedisCacheNode("Redis-Node-2");
        CacheObserver cache3 = new RedisCacheNode("Redis-Node-3");

        publisher.subscribe(cache1);
        publisher.subscribe(cache2);
        publisher.subscribe(cache3);

        // Simulate DB update
        publisher.updateData("user:101");
    }
}
