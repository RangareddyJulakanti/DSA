package com.ranga.leetcode.arrays;

import java.util.stream.IntStream;

public class TrappingRainWater {
    public static void main(String[] args) {
        int []A={4,2,0,3,2,5};//2+4+1+2
        int n=A.length;
        int []leftMax=new int[n];
        leftMax[0]=A[0];
        for(int i=1;i<n;i++){
           leftMax[i]=Integer.max(leftMax[i-1],A[i]);
        }
        IntStream.of(leftMax).forEach(System.out::print);
        int []rightMax=new int[n];

        System.out.println(" ");
        IntStream.of(rightMax).forEach(System.out::print);
        //Wi = min(LeftMax(i)-RightMax(i)) - Hi
       int sum=0;
       for(int j=0;j<n;j++){
           int h=Integer.min(leftMax[j],rightMax[j])-A[j];
           sum=sum+h;
       }
        System.out.println(" ");
        System.out.println(sum);
        System.out.println(1-Integer.MIN_VALUE);
    }
}
