package com.ranga.dsa.carryforward;

/***
 *
 * Find the smallest subarray length which contains max and min
 * I: 0  1  2  3  4  5  6  7  8  9  10
 * A: 2  2  6  4  5  1  5  2  6  4  1
 *
 * MAX =6,MIN =1
 * indexes =[2,5] [5,8] [8,10]
 * length  = 4    4       3
 *
 * find the length formula [a,b]==b-a+1
 */

public class SmallestSubArrayLength {
    public static void main(String[] args) {

        int []a={2,2,6,4,5,1,5,2,6,4,1};
        //1.find max
        //2.find min
        int min=a[0];
        int max=a[0];
        for(int n:a){
            min=Math.min(min,n);
            max=Math.max(max,n);
        }
        System.out.println(min);
        System.out.println(max);
        int N=a.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if(a[i]==max){
                for(int j=i+1;j<N;j++){
                    if(a[j]==min){
                      ans=Math.min(ans,j-i+1);
                      break;
                    }
                }
            }
            if(a[i]==min){
                for(int j=i+1;j<N;j++){
                    if(a[j]==max){
                        ans=Math.min(ans,j-i+1);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
