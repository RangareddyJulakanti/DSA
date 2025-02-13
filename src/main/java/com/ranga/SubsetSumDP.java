package com.ranga;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubsetSumDP  implements Runnable{

    public  void findAndRemoveSubsets(int[] arr, IntStream targets) {
        final List<Integer>[] arrList = new List[]{new ArrayList<>(arr.length)};
        for (int num : arr) {
            arrList[0].add(num);
        }

        targets.peek(val->{
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).forEach(target -> {
            Set<Integer> subset = findFirstSubset(arrList[0], target);
            if (subset.isEmpty()) {
                System.out.println("No subset with sum " + target);
            } else {
                System.out.println("Subset with sum " + target + ": " + subset);
                arrList[0] = removeElements(arrList[0], subset);
            }
        });
    }

    private  Set<Integer> findFirstSubset(List<Integer> arrList, int target) {
        int n = arrList.size();
        boolean[][] dp = new boolean[n + 1][target + 1];

        // A sum of 0 can always be achieved with an empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arrList.get(i - 1) <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arrList.get(i - 1)];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // If target sum is not achievable, return empty set
        if (!dp[n][target]) {
            return Collections.emptySet();
        }

        // Backtrack to find the subset using streams
        List<Integer> subsetList = new ArrayList<>();
        for (int sum = target, i = n; sum > 0; i--) {
            if (i == 0 || !dp[i - 1][sum]) {
                subsetList.add(arrList.get(i - 1));
                sum -= arrList.get(i - 1);
            }
        }

        // Clear the dp table if needed
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], false);
        }
        // Convert the list to a LinkedHashSet to maintain insertion order
        return subsetList.stream().collect(Collectors.toSet());
    }

    private  List<Integer> removeElements(List<Integer> arrList, Set<Integer> subset) {
        List<Integer> result = new ArrayList<>();
        for (int num : arrList) {
            if (!subset.contains(num)) {
                result.add(num);
            } else {
                subset.remove(num); // Ensure only one occurrence is removed
            }
        }
        return result;
    }

    int[] source;
    IntStream target;

    public SubsetSumDP(int[] source,IntStream target){
      this.source=source;
      this.target=target;
    }
    public void run(){
        findAndRemoveSubsets(source,target);
    }
}
