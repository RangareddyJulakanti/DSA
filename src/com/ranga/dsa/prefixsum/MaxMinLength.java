package com.ranga.dsa.prefixsum;

public class MaxMinLength {
    public static void main(String[] args) {
        int  A[]={6,4,1,2,5,7};
        // step1: find min and max
        int min=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
               min=Math.min(min,A[i]);
               max=Math.max(max,A[i]);
        }
        System.out.println(min+"--"+max);

        int last_min=Integer.MIN_VALUE;
        int last_max=Integer.MIN_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]==max){
              last_max=i;
            }
            if(A[i]==min){
             last_min=i;
            }
            if(last_min==Integer.MIN_VALUE||last_max==Integer.MIN_VALUE){
                continue;
            }else{
                if(A[i]==max){
                    ans=Math.min(ans,i-last_min+1);
                }else if(A[i]==min){
                    ans= Math.min(ans,i-last_max+1);
                }
            }
        }
        System.out.println(ans);
    }
}
