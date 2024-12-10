package com.ranga.delloit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSubsetSum {

    // Function to find the first subset with a given target sum
    public static List<Integer> findFirstSubsetSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        if (findSubset(nums, target, result, 0)) {
            return result;
        }
        return null; // No subset found
    }

    // Helper function to find the subset using backtracking
    private static boolean findSubset(int[] nums, int target, List<Integer> result, int start) {
        if (target == 0) {
            return true; // Found a subset
        }
        if (target < 0 || start >= nums.length) {
            return false; // Out of bounds or negative target
        }

        // Include nums[start] in the subset
        result.add(nums[start]);
        if (findSubset(nums, target - nums[start], result, start + 1)) {
            return true;
        }

        // Exclude nums[start] from the subset and backtrack
        result.remove(result.size() - 1);
        return findSubset(nums, target, result, start + 1);
    }

    // Function to remove the first occurrence of each element in subset from the array
    public static int[] removeSubset(int[] nums, List<Integer> subset) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        for (int num : subset) {
            numList.remove(Integer.valueOf(num));
        }

        // Convert list back to array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10, 12, 5, 6, 1, 1};  // Example array
        int target = 15;  // Example target sum

        List<Integer> subset = findFirstSubsetSum(nums, target);
        if (subset != null) {
            System.out.println("First subset with sum " + target + ": " + subset);
            nums = removeSubset(nums, subset);
            System.out.println("Array after removing the subset: " + Arrays.toString(nums));
        } else {
            System.out.println("No subset with sum " + target + " found.");
        }
    }
}
