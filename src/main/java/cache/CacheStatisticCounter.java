package cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dominik_Janiga
 */
class CacheStatisticCounter implements Counter {

    AtomicInteger existingKeyNumber = new AtomicInteger();
    AtomicInteger evictedEntriesNumber = new AtomicInteger();

    @Override
    public void increaseExistingKeyNumber() {
        this.existingKeyNumber.incrementAndGet();
    }

    @Override
    public void increaseEvictedEntriesNumber() {
        this.evictedEntriesNumber.incrementAndGet();
    }

    AtomicInteger getExistingKeyNumber() {
        return this.existingKeyNumber;
    }

    AtomicInteger getEvictedEntriesNumber() {
        return this.evictedEntriesNumber;
    }
}
