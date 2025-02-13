package com.ranga.dsa;

public class MaxProfitSum {
    public static void main(String[] args) {

             // -3 -19 -42 -24 -4 -11 1 -4 -26
        int[] a={-3,-16,-23,18,20,-7,12,-5,-22};//18,20,-7,12
               //0   1   2   3  4  5  6  7   8
             //s 0
             //e 0
            //sum-3
           int n=a.length;
           //Build prefix sum
           int b[] =new int[n];
           b[0]=a[0];
           for(int i=1; i<n;i++){
               b[i]=b[i-1]+a[i];
           }
           int maxsum=0;
           int start=0,end=0;
           for(int s=0;s<n;s++){

               int e=s;
               for(;e<n;e++){
                   int sum;
                   if(s==0){
                      sum=b[e];
                   }else{
                       sum=b[e]-b[s-1];
                   }
                   /*if(maxsum<sum){
                       maxsum=sum;
                       start=s;
                       end=e;
                   }*/
                   System.out.println(sum);
               }
           }
        System.out.println(maxsum);
        System.out.println(start+"----"+end);
    }
}
