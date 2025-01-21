package com.ranga.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoSumSorted {
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int target =9;
        List<List<Integer>> matchedIndexes=new ArrayList<>();
        for(int i=0,j=arr.length-1;i<j;){
            int sum=arr[i]+arr[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                matchedIndexes.add(List.of(i,j));
                i++;
                j--;
            }
        }
        System.out.println(matchedIndexes);
    }
}
