package cache;

/**
 * @author Dominik_Janiga
 */
public class LFUCache {

    private final Storage<Integer, Entry> cacheStorage;
    private final EvictionStrategy<Integer> evictionStrategy;
    private final int capacity;
    private final Counter counter;
    /*


    Max Size = 100 000;
    Eviction policy;
    Time-based on last access (5 seconds);
    Removal listener;
    Just add to log of removed entry;
    Give statistic to user;
    Average time spent for putting new values into the cache;
    Number of cache evictions;
    Support concurrency.


     */
    LFUCache(Storage<Integer, Entry> cacheStorage, EvictionStrategy<Integer> evictionStrategy, int capacity,
            Counter counter) {
        this.cacheStorage = cacheStorage;
        this.evictionStrategy = evictionStrategy;
        this.capacity = capacity;
        this.counter = counter;
    }

    Entry get(int entryKey) {
        this.evictionStrategy.updateKeyUsage(entryKey);
        return cacheStorage.get(entryKey);
    }

    void put(Integer key, Entry value) {
        this.evictionStrategy.addKey(key);
        this.cacheStorage.put(key, value);
        if (this.cacheStorage.size() > this.capacity) {
            Integer removedKey = this.evictionStrategy.removeKey();
            this.cacheStorage.remove(removedKey);
        }
    }


    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(new CacheStorage(), new LFUEvictionStrategy(), 10, new CacheStatisticCounter());

        Entry entry = new Entry("entry");
        lfuCache.put(1, entry);
        lfuCache.put(2, entry);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
//        Map<Integer, Integer> counts = lfuCache.counts;
//        System.out.println("counts: " + counts);
    }
}
