package com.ranga.dp;

import java.util.Scanner;

public class Fibonacci {
    private static int a[];
    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13,21
        Scanner sc=new Scanner(System.in);
        int nThFibonacci=sc.nextInt();
        a=new int[nThFibonacci+1];
        findFibonacci(nThFibonacci);
        for (int r:a){
            System.out.println(r);
        }
    }
    public static int findFibonacci(int n){
        if(n==0) {
            a[n] = 0;
            return 0;
        }
        if(n==1) {
            a[n]=1;
            return 1;
        }
        if(a[n]!=0){
            return a[n];
        }

        int sum= findFibonacci(n-1)+findFibonacci(n-2);
        a[n]=sum;
        return sum;

    }
}
