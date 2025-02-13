package com.ranga.scaler.dsa.goldmansach;

public class ArrayPartition {
    public static void main(String[] args) {
        int[] array={1,5,11,5};
        boolean result=canPartition(array);
        System.out.println("Can Partition: "+result);
    }
    private static boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum=totalSum+num;
        }
        if(totalSum%2!=0){
            return false;
        }
        int target=totalSum/2;
       return canPartition(nums,nums.length,target);
    }
    private static boolean canPartition(int[] nums, int l, int target) {
        if(target==0){
            return true;
        }
        if(l==0||target<0){
            return false;
        }
        boolean exclude=canPartition(nums,l-1,target);
        boolean include=canPartition(nums,l-1,target-nums[l-1]);
        return exclude||include;
    }
}
