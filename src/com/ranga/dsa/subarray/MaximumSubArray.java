package com.ranga.dsa.subarray;

public class MaximumSubArray {
    public static void main(String[] args) {
        int A[]={13,-3,-25,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int N=A.length;
        int maximum=Integer.MIN_VALUE;
        for(int S=0;S<N;S++){
            int sum=0;
            for(int E=S;E<N;E++){
                sum=sum+A[E];
                maximum=Integer.max(maximum,sum);
            }

        }
        System.out.println(maximum);
    }
}
