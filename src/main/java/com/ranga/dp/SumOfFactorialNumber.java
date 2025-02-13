package com.ranga.dp;

/**
 * Q: Find the Minimum number of perfect squares to get the sum =N
 */

public class SumOfFactorialNumber {
    public static void main(String[] args) {
        int n=12;
        System.out.println(calc(n));
    }

    private static int calc(int n) {
        int[] squares=new int[n+1];
        if(n==0){
            return 0;
        }
        if(squares[n]!=0){
            return squares[n];
        }
        int ans=Integer.MAX_VALUE;
        for(int x=1;x*x<=n;x++){
            ans=Integer.min(ans,calc(n-x*x));
        }
        squares[n]=1+ans;
        return squares[n];

    }
}
