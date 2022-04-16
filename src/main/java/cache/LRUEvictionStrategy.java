package cache;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dominik_Janiga
 */
class LRUEvictionStrategy implements EvictionStrategy<Integer> {

    // kolejka kluczy
    Queue<Integer> cacheKeys = new LinkedList<>();


    @Override
    public void updateKeyUsage(Integer key) {
        this.cacheKeys.remove(key);
        this.cacheKeys.add(key);
    }

    @Override
    public void addKey(Integer key) {
        this.cacheKeys.add(key);
    }
}
