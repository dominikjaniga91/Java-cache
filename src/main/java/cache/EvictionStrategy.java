package cache;

/**
 * @author Dominik_Janiga
 */
public interface EvictionStrategy<Key> {

    /**
     * Mark provided key as recently used by moving it to the end of the queue.
     *
     * @param key - key of the cache entry.
     */
    void updateKeyUsage(Key key);

    /**
     * Add key to cache keys queue.
     *
     * @param key - key of the cache entry.
     */
    void addKey(Key key);

    default EvictionStrategy<Integer> selectStrategy(String strategyName) {

        if ("LFUCache".equals(strategyName)) {
            return new LFUEvictionStrategy();
        } else {
            throw new IllegalArgumentException("No eviction strategy found");
        }
    }

    Key getKeyToRemove();

    Key removeKey();
}
