package cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author Dominik_Janiga
 */
class LFUEvictionStrategy implements EvictionStrategy<Integer> {

    private final Map<Integer, AtomicInteger> counts = new ConcurrentHashMap<>();
    private final ConcurrentSkipListMap<Integer, Set<Integer>> frequencyMap = new ConcurrentSkipListMap<>();


    @Override
    public void updateKeyUsage(Integer key) {
        if (this.counts.containsKey(key)) {
            AtomicInteger usageCount = this.counts.get(key);
            this.frequencyMap.get(usageCount.intValue()).remove(key);
            int newUsageCount = usageCount.incrementAndGet();

            if (this.frequencyMap.containsKey(newUsageCount)) {
                this.frequencyMap.get(newUsageCount).add(key);
            } else {
                Set<Integer> keys = new LinkedHashSet<>();
                keys.add(key);
                this.frequencyMap.put(usageCount.intValue(), keys);
            }
        }
    }

    @Override
    public void addKey(Integer key) {

        if (!this.counts.containsKey(key)) {
            AtomicInteger usageCount = new AtomicInteger(1);
            this.counts.put(key, usageCount);
            Set<Integer> keys = new LinkedHashSet<>();
            keys.add(key);
            this.frequencyMap.put(usageCount.intValue(), keys);
        }
    }

    @Override
    public Integer getKeyToRemove() {
        Map.Entry<Integer, Set<Integer>> leastFrequentlyUseEntry = this.frequencyMap.firstEntry();
        Set<Integer> keys = leastFrequentlyUseEntry.getValue();
        Integer keyToRemove = keys.iterator().next();
        keys.remove(keyToRemove);
        this.counts.get(keyToRemove).decrementAndGet();
        return keyToRemove;
    }

    @Override
    public Integer removeKey() {
        Map.Entry<Integer, Set<Integer>> leastFrequentlyUseEntry = this.frequencyMap.firstEntry();
        Set<Integer> keys = leastFrequentlyUseEntry.getValue();
        Integer keyToRemove = keys.iterator().next();
        keys.remove(keyToRemove);
        this.counts.get(keyToRemove).decrementAndGet();
        return keyToRemove;

    }

    private Set<Integer> mergeSet(Set<Integer> oldSet, Set<Integer> newSet) {

        System.out.println(" old set: " + oldSet);
        System.out.println(" new set: " + newSet);
        Set<Integer> mergeSet = new LinkedHashSet<>();
        mergeSet.addAll(oldSet);
        mergeSet.addAll(newSet);

        return mergeSet;
    }
}
