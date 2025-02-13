package com.ranga.scaler.dsa.day34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Find the frequency of numbers Given  N Array elements &
 * Q quries for each query find freq of that elements in the array.
 * int []elements ={2,6,3,8,2,8,2,3,8,10};
 * Quires :Ans
 * 2: 3
 * 8: 3
 * 3: 2
 * 5: 0
 */
public class HashMapDemo1 {
    public static void main(String[] args) {
        int[] elements = {2, 6, 3, 8, 2, 8, 2, 3, 8, 10};
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : elements) {
            freqMap.computeIfPresent(element, (key,value)->value+1);
            freqMap.computeIfAbsent(element, e -> 1);
        }
        int[] queries = {2, 8, 3, 5};
        for (int query : queries) {
            Optional.ofNullable(freqMap.get(query)).ifPresentOrElse(System.out::println,()->System.out.println(0));
        }
    }
}
