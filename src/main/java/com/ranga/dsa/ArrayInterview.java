package com.ranga.dsa;

/**
 * Find number of triplets in given array.
 * indexes i,j,k
 * constraints: A[i]<A[j]<A[k]
 *
 * EX: A: 3 4 6 9 2
 *     I: 0 1 2 3 4
 *
 *     i   j  k
 *     0   1  2
 *     0   1  3
 *     0   2  3
 *     1   2  3
 *
 *     these are 4 valid triplets
 *
 */
public class ArrayInterview {
    public static void main(String[] args) {
        int []A=new int[]{3,4,6,9,2};
        int N=A.length;
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    if(A[i]<A[j]&&A[j]<A[k]){
                       count++;
                    }
                }
            }
        }
        System.out.println(count);
        int totalPairs=0;
        for(int j=1;j<N;j++){
            int leftSmall=0;
            for(int i=j-1;i>=0;i--){
                if(A[i]<A[j]){
                    leftSmall++;
                }
            }
            int rightBig=0;
            for(int k=j+1;k<N;k++){
                if(A[j]<A[k]){
                    rightBig++;
                }
            }
            totalPairs=totalPairs+(leftSmall*rightBig);
        }
        System.out.println(totalPairs);
    }
}
