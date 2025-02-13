package com.ranga.dsa.carryforward;

import java.util.stream.IntStream;

/**
 * Given an array, build  the left max array.
 * leftMax[i]=max value array from 0 to i
 *
 *      index:   0 1 2 3 4 5  6
 *      array:  -3 6 2 4 5 2 -9
 *
 *    leftMax:  -3 6 6 6 6 6  6
 *
 *   rightMax:   6 6 5 5 5 2 -9
 *
 * Left Max Logic:
 *
 *      leftMax[0]=a[0]
 *      leftMax[1]=max(a[0],a[1]) its equivalent  to leftMax[1]=max(leftMax[0],a[1]);
 *      leftMax[2]=max(leftMax[1],a[2]);
 *      leftMax[3]=max(leftMax[2],a[3]);
 *      Generalize from above observations
 *      leftMax[i]=max(leftMax[i-1],a[i]);
 *
 * Right Max Logic:
 *
 *      rightMax[n-1]=a[n-1]
 *      rightMax[n-2]=max(rightMax[n-1],a[n-2])
 *      rightMax[n-3]=max(rightMax[n-2],a[n-3]
 *      Generalize from above observations
 *      rightMax[i]=max(rightMax[i+1],a[i])
 *
 */
public class CarryForward1 {
    public static void main(String[] args) {
      int [] a={-3,6,2,4,5,2,-9};
      int n=a.length;

      int [] leftMax=new int[n];
      leftMax[0]=a[0];
      for(int i=1;i<n;i++){
          leftMax[i]=Integer.max(leftMax[i-1],a[i]);
      }
        IntStream.of(leftMax).forEach(System.out::print);
      int [] rightMax=new int[n];     
      rightMax[n-1]=a[n-1];
      for(int i=n-2;0<=i;--i){
          rightMax[i]=Integer.max(rightMax[i+1],a[i]);
      }
        System.out.println("");
        IntStream.of(rightMax).forEach(System.out::print);
    }
}
