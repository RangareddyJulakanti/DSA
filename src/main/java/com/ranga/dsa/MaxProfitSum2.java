package com.ranga.dsa;

public class MaxProfitSum2 {

    public static void main(String[] args) {
        // -3 -19 -42 -24 -4 -11 1 -6 -28
        int[] a={-3,-16,-23,18,20,-7,12,-5,-22};//18,20,-7,12
        //0   1   2   3  4  5  6  7  8
        int n=a.length;
        //Build prefix sum

        int maxsum=0;
        int start=0,end=0;
        for(int s=0;s<n-1;s++){
             int sum=0;
            for(int e=s;e<n-1;e++){
                sum=sum+a[e];
                if(maxsum<sum){
                    maxsum=sum;
                    start=s;
                    end=e;
                }
            }
        }
        System.out.println(maxsum);
        System.out.println(start+"----"+end);
    }
}
