package com.ranga.recursion;

import com.ranga.SubsetSumDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSum {

    public  Set<Integer> findFirstSubset(List<Integer> arrList, int target) {
        int n = arrList.size();
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 can always be achieved with an empty subset

        // Fill the DP table
        for (int i = 0; i < n; i++) {
            int currentValue = arrList.get(i);
            for (int j = target; j >= currentValue; j--) {
                dp[j] = dp[j] || dp[j - currentValue];
            }
        }

        // If target sum is not achievable, return an empty set
        if (!dp[target]) {
            return new HashSet<>();
        }

        // Backtrack to find the subset
        List<Integer> subsetList = new ArrayList<>();
        for (int sum = target, i = n - 1; sum > 0; i--) {
            if (i < 0) break; // Avoid index out of bounds
            int currentValue = arrList.get(i);
            if (sum >= currentValue && dp[sum - currentValue]) {
                // Include the current element
                subsetList.add(currentValue);
                sum -= currentValue;
            }
        }

        // Return the subset as a HashSet to maintain uniqueness
        return new HashSet<>(subsetList);
    }

}
