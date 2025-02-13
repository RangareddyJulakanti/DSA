package com.ranga.leetcode.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class _3SumClosest {
    public static void main(String[] args) {
        int a[] ={-1,2,1,-4};
       //sort the array
        Arrays.sort(a);
        int size=a.length;
        int target=1;
        int closedSum=Integer.MAX_VALUE;
        //Fix first element and do two pointer approach
        for(int k=0;k<size-2;k++){
            int i=k+1;
            int j=size-1;
            while(i<j){
                int sum = a[i]+a[j]+a[k];
                if(Math.abs(target-sum)<Math.abs(target-closedSum)){
                    closedSum=sum;
                }
                if(sum<target){
                    i++;
                }else{
                    j--;
                }
            }
        }
        System.out.println(closedSum);
    }
}
