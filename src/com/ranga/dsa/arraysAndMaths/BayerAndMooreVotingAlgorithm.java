package com.ranga.dsa.arraysAndMaths;

public class BayerAndMooreVotingAlgorithm {
    public static void main(String[] args) {
       int []A={2,2,1,1,1,2,2};
       int N=A.length;

       int element;
       int freq=1;
       element=A[0];
       for(int i=1;i<N;i++){
           if(element==A[i]){
               freq++;
           }else{
               if(freq==0){
                   element=A[i];
                   freq=1;
               }else {
                   freq--;
               }
           }


       }
       int count=0;
        for(int i : A) {
            if (element == i) {
                count++;
            }
        }
        if(count>N/2){
            System.out.println("Frequency element found :"+element);
        }

    }
}
