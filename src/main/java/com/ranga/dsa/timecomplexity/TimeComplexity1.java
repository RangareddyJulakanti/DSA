package com.ranga.dsa.timecomplexity;

public class TimeComplexity1 {
    public static void main(String[] args) {
    }

    public void solve(int n) {
        int i = n;
        while (i > 0) {
            if (i % 2 == 0) {
                for (int j = 1; j <= n * n; j += 2) {                // O(1) operation
                }
            }
            i /= 2;
        }
    }
}
