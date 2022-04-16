package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominik_Janiga
 */
class CacheStorage implements Storage<Integer, Entry> {

    private final Map<Integer, Entry> cacheStorage;

    CacheStorage() {
        this.cacheStorage = new HashMap<>();
    }

    @Override
    public void put(Integer key, Entry value) {
        this.cacheStorage.putIfAbsent(key, value);
    }

    @Override
    public Entry get(Integer key) {
        return this.cacheStorage.get(key);
    }

    @Override
    public void remove(Integer key) {
        this.cacheStorage.remove(key);
    }

    @Override
    public int size() {
        return this.cacheStorage.size();
    }

    @Override
    public boolean containsKey(Integer key) {
        return this.cacheStorage.containsKey(key);
    }
}
