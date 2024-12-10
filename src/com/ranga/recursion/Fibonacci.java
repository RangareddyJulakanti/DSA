package com.ranga.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21
        int n=6;
        int result= fibo(n);
        System.out.println(result);
    }
    private static int fibo(int n) {
        if(n==0){
            return 0;
        }
        if(n==1)
            return 1;

        int sum=fibo(n-1)+fibo(n-2);
        return sum;
    }
}
