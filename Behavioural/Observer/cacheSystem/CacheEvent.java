package Behavioural.Observer.cacheSystem;

public class CacheEvent {
    private final String key;

    public CacheEvent(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
