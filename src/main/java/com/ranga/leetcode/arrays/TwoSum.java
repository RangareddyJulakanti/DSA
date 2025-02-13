package com.ranga.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoSum {
    public static void main(String[] args) {
        int arr[]={3,3};
        int target =6;

        /**
         * Brute force approach
         * T(C): O(n^2)
         */
        for(int i=0;i< arr.length;i++){
            int remaining=target-arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(remaining==arr[j]){
                    System.out.println("target value found == ("+i+" "+j+")");
                }
            }
        }
        int res[]=new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remaining=target - arr[i];
            if (map.containsKey(remaining)) {
                res=new int[] { map.get(remaining), i };
            }
            map.put(arr[i], i);
        }
        for(int num:res){
            System.out.println(num);
        }
    }
}
