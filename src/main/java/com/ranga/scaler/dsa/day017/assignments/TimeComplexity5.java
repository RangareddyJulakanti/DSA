package com.ranga.scaler.dsa.day017.assignments;

public class TimeComplexity5 {
    public static void main(String[] args) {

    }

    public static void solve(int N) {
        int a = 0, i = N;
        while (i > 0) {
            a += i;
            i /= 2;
        }
    }
}
