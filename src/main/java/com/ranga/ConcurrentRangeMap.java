package com.ranga;

import com.google.common.collect.Range;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentRangeMap<K extends Comparable<K>, V> {
    private final ConcurrentSkipListMap<K, Range<K>> rangeMap = new ConcurrentSkipListMap<>();
    private final ConcurrentSkipListMap<Range<K>, V> valueMap = new ConcurrentSkipListMap<>((r1, r2) -> {
        int cmp = r1.lowerEndpoint().compareTo(r2.lowerEndpoint());
        return cmp != 0 ? cmp : r1.upperEndpoint().compareTo(r2.upperEndpoint());
    });

    // Add a range with its associated value
    public synchronized void put(Range<K> range, V value) {

        rangeMap.put(range.lowerEndpoint(), range);
        valueMap.put(range, value);
    }
    public Set<Map.Entry<Range<K>, V>> entrySet() {
        return valueMap.entrySet();
    }

    // Remove a range and its associated value
    public synchronized void remove(Range<K> range) {
        rangeMap.remove(range.lowerEndpoint());
        valueMap.remove(range);
    }

    // Get the value for a given key
    public V get(K key) {
        Map.Entry<K, Range<K>> entry = rangeMap.floorEntry(key);
        if (entry != null && entry.getValue().contains(key)) {
            return valueMap.get(entry.getValue());
        }
        return null;
    }

    // Print all ranges and their values
    public void printRanges() {
        for (Map.Entry<Range<K>, V> entry : valueMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ConcurrentRangeMap<Integer, String> concurrentRangeMap = new ConcurrentRangeMap<>();

        concurrentRangeMap.put(Range.closed(1, 5), "Range1");
        concurrentRangeMap.put(Range.closed(6, 10), "Range2");

        System.out.println("Value for key 3: " + concurrentRangeMap.get(3));  // Output: Range1
        System.out.println("Value for key 7: " + concurrentRangeMap.get(7));  // Output: Range2

        concurrentRangeMap.remove(Range.closed(1, 5));

        System.out.println("Value for key 3 after remo" +
                "val: " + concurrentRangeMap.get(3));  // Output: null

        concurrentRangeMap.printRanges();
    }
}
