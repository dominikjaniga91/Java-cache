package cache;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Dominik_Janiga
 */
public class LFUCacheTest {

    private static final String ENTRY_NAME = "entry_name";

    @Test
    public void shouldReturnEntryWithGivenKey() {
        //given
        int capacity = 10;
        EvictionStrategy<Integer> evictionStrategy = new LFUEvictionStrategy();
        Storage<Integer, Entry> caches = new CacheStorage();
        Entry expectedEntry = new Entry("entry_name");
        caches.put(1, expectedEntry);
        evictionStrategy.addKey(1);
        LFUCache lfuCache = new LFUCache(caches, evictionStrategy, capacity, new CacheStatisticCounter());

        //when
        Entry actualEntry = lfuCache.get(1);

        //then
        Assertions.assertEquals(expectedEntry, actualEntry, "Entries are not the same. Actual: " + actualEntry + ", expected: " + expectedEntry);
    }

    @Test
    public void shouldPutNewEntryInCache() {
        //given
        int capacity = 2;
        EvictionStrategy<Integer> evictionStrategy = new LFUEvictionStrategy();
        Storage<Integer, Entry> caches = new CacheStorage();
        LFUCache lfuCache = new LFUCache(caches, evictionStrategy, capacity, new CacheStatisticCounter());
        Entry entry = new Entry("test-entry");
        lfuCache.put(1, entry);

        Assertions.assertEquals(1, caches.size());
    }

    @Test
    public void dfdsfsds() {

        int capacity = 1;
//        TreeMap<Integer, Set<Integer>> expectedFrequencyMap = Map

        EvictionStrategy<Integer> evictionStrategy = new LFUEvictionStrategy();
        Storage<Integer, Entry> caches = new CacheStorage();
        LFUCache lfuCache = new LFUCache(caches, evictionStrategy, capacity, new CacheStatisticCounter());
        Entry entry = new Entry("test-entry");
//        caches.put(1, entry);
//        counts.put(1, 0);
        lfuCache.put(1, entry);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(1);

        Assertions.assertEquals(1, caches.size());
    }

    @Test
    public void getNumberOfCacheEvictions_shouldReturnFive_afterAddFiveEntriesOverCapacity() {
//        //given
//        int expectedNumberOfCacheEvictions = 5;
//        int capacity = 1;
//        EvictionStrategy<Integer> evictionStrategy = new LFUEvictionStrategy();
//        Storage<Integer, Entry> caches = new CacheStorage();
//        LFUCache lfuCache = new LFUCache(caches, evictionStrategy, capacity, new CacheStatisticCounter());
//        Entry entry = new Entry("test-entry");
//        int entryKey = 1;
//        caches.put(entryKey, entry);
//        int frequency = 0;
//        LinkedHashSet<Integer> entryKeys = new LinkedHashSet<>();
//        entryKeys.add(entryKey);
//
//        //when
//        lfuCache.put(2, entry);
//        lfuCache.put(3, entry);
//        lfuCache.put(4, entry);
//        lfuCache.put(5, entry);
//        lfuCache.put(6, entry);
//
//        //then
//        Assertions.assertEquals(expectedNumberOfCacheEvictions, lfuCache.getNumberOfCacheEvictions());
    }

}
