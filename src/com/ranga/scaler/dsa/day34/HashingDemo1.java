package com.ranga.scaler.dsa.day34;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Given N Array elements,
 * Find distinct no of elements.
 *   int []arr={3,5,6,5,4,3};  ans: 4 =[3,5,6,4]
 */
public class HashingDemo1 {
    public static void main(String[] args) {
        int []elements = {3,5,6,5,4,3};

        //Brute Force approach
       // ----------------------
        int totalDuplicateElement=0;
        for(int i=0;i<elements.length;i++){
            for(int j=i+1;j<elements.length;j++){
                if(elements[i]==elements[j]){
                    totalDuplicateElement++;
                }
            }
        }
        System.out.println("Unique Count="+(elements.length-totalDuplicateElement));

        Set<Integer> hashSet=new HashSet<>();
        for(int element:elements){
            hashSet.add(element);
        }
        System.out.println(hashSet.size());
        //TC: O(N) SC: O(N)

        long count = IntStream.of(elements).boxed().distinct().count();
        //TC : O(N) SC: O(N) internally using LinkedHashSet for eliminate duplicates
        System.out.println(count);
    }
}
