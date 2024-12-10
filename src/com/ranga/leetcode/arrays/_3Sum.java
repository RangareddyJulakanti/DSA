package com.ranga.leetcode.arrays;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]= [-4,-1,-1,0,1,2]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class _3Sum {
    public static void main(String[] args) {
                                       //0  1  2  3 4 5
         int []input={-1,0,1,2,-1,-4};//[-4,-1,-1,0,1,2]
        System.out.println(threeSum(input));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int size= nums.length;
        if(size<3){
            return List.of(List.of());
        }
        Arrays.sort(nums);
        //fixing one element
       for(int i=0;i<size;i++){
          if(i>0&&nums[i]==nums[i-1]){
              continue;
          }
          int n1=nums[i];
          int target=-n1;
           Set<List<Integer>> twoSumResult= twoSum(nums,target,i+1,size-1);
           if(!twoSumResult.isEmpty()) {
               twoSumResult.forEach(list->{
                   result.add(List.of(n1, list.get(0), list.get(1)));
               });
           }

       }
       return result;
    }

    private static Set<List<Integer>> twoSum(int[] nums, int target, int i, int j) {
        Set<List<Integer>> matchedIndexes=new HashSet<>();
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                matchedIndexes.add(List.of(nums[i],nums[j]));
                i++;
                j--;
            }
        }
       return matchedIndexes;
    }

}
