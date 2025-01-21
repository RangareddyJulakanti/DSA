package com.ranga.scaler.dsa.day017.assignments;
/**
 * 0/2,1/2,2/2,3/2,4/2,5/2,6/2,.........n-1/2
 *  n(n-1)/4
 */
public class TimeComplexity2 {
   public static void solve(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i / 2; j++) {
                // O(1) operation
            }
        }
    }
}
