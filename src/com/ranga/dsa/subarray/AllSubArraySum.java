package com.ranga.dsa.subarray;

/**
 * Print sum of each subarray sum
 *  I: 0    1    2    3    4     5   6
 *  A: 7    3    2   -1    6     8   2
 *
 */
public class AllSubArraySum {
    public static void main(String[] args) {
        int [] A={7 ,3, 2 ,-1 , 6 ,8, 2};
        int N=A.length;
        //Prefix sum
        int[] ps = new int[A.length];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        for(int s=0;s<N;s++){
            int sum=0;
            for(int e=s;e<N;e++){
                if(s==0){
                    sum= ps[e];
                }else {
                    sum = ps[e] - ps[s - 1];
                }
                System.out.println(sum);
            }
        }

        /**
         *     Without prefix sum
         *  * Print sum of each subarray sum
         *  *  I: 0    1    2    3    4     5   6
         *  *  A: 7    3    2   -1    6     8   2
         */


        for(int s=0;s<N;s++) {
            int sum = 0;
            for (int e = s; e < N; e++) {
                sum=sum+A[e];
                System.out.println(sum);
            }

        }


    }
}
