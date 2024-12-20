package com.ranga.dsa.carryforward;
/***
 *
 * Find the smallest subarray length which contains max and min
 * I:   0   1   2   3   4   5   6   7   8   9   10
 * A:   2   2   6   4   5   1   5   2   6   4   1
 *
 * find the min and max latest/recent indexes for the same and update as well like the below
 *
 * MIN  -1  -1  -1  -1  -1  5   5   5   5   5   10
 * MAX   -1  -1  2   2   2  2   2   2   8   8   8
 * MAX =6,MIN =1
 * indexes =[2,5] [5,8] [8,10]
 * length  = 4    4       3
 *
 * find the length formula [a,b]==b-a+1
 */
public class O_SmallestSubArrayLength {
    public static void main(String[] args) {
        int []a={2,2,6,4,5,1,5,2,6,4,1};
        int min=a[0];
        int max=a[0];
        for(int n:a){
            min=Math.min(min,n);
            max=Math.max(max,n);
        }
        int N=a.length;
        int latest_min=-1;
        int latest_max=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if(a[i]==max){
                latest_max=i;
                if(latest_min!=-1) {
                    ans = Math.min(ans,i-latest_min+1);
                    System.out.println("ANS="+ans);
                }
            }
            if(a[i]==min){
                latest_min=i;
                if(latest_max!=-1){
                    ans=Math.min(ans,i-latest_max+1);
                    System.out.println("ANS="+ans);
                }
            }
        }
        System.out.format("smallest length %s",ans);
    }
}
