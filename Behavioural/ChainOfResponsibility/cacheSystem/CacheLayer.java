package Behavioural.ChainOfResponsibility.cacheSystem;

public abstract class CacheLayer {
    protected CacheLayer next_handler;

    public CacheLayer setNext(CacheLayer next){
        this.next_handler = next;
        return next;
    }

    public abstract String get(String key);

    public abstract void put(String key, String value);
}
