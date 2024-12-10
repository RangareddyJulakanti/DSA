package com.ranga.delloit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    // Function to find a subset with a given target sum using dynamic programming
    public static List<Integer> findSubsetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        int[] subset = new int[target + 1];
        Arrays.fill(subset, -1);

        dp[0] = true;

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                if (dp[t - num]) {
                    dp[t] = true;
                    subset[t] = num;
                }
            }
        }

        if (!dp[target]) {
            return null; // No subset found
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int t = target;
        while (t > 0 && subset[t] != -1) {
            result.add(subset[t]);
            t -= subset[t];
        }

        return result;
    }

    // Function to remove the subset from the array
    public static int[] removeSubset(int[] nums, List<Integer> subset) {
        int[] result = new int[nums.length - subset.size()];
        int index = 0;
        
        for (int num : nums) {
            if (index < result.length && !subset.contains(num)) {
                result[index++] = num;
            } else if (subset.contains(num)) {
                subset.remove(Integer.valueOf(num)); // Remove the first occurrence of num from subset
            }
        }
        
        return result;
    }

    // Function to process subsets and return all found subsets
    public static List<List<Integer>> processSubsets(int[] nums, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset;
        
        while ((subset = findSubsetSum(nums, target)) != null) {
            subsets.add(subset);
            nums = removeSubset(nums, subset);
        }
        
        return subsets;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 8, 10, 12, 5, 6, 1, 1, 8};  // Example array
        int target = 15;  // Example target sum

        List<List<Integer>> subsets = processSubsets(nums, target);
        System.out.println("Subsets found: " + subsets);
    }
}
