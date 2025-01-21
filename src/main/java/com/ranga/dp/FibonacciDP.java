package com.ranga.dp;

public class FibonacciDP {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21
        int n=6;
        int[] a =new int[n+1];
        a[0]=0;
        a[1]=1;
        fibo(n,a);
        for (int j : a) {
            System.out.println(j);
        }

    }

    private static int fibo(int n, int[] a) {
        if(n==0){
            return 0;
        }
        if(a[n]!=0){
            return a[n];
        }
        a[n]=fibo(n-1,a)+fibo(n-2,a);
        return a[n];

    }
}
