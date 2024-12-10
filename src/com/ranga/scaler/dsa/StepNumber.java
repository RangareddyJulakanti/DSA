package com.ranga.scaler.dsa;


public class StepNumber {
    public static void main(String[] args) {
     int steps=6;
        System.out.println(nThSteps(steps));
    }
    private static int nThSteps(int n) {
        if(n==1)
          return 1;
        if(n==2)
          return 2;
        return nThSteps(n-1)+nThSteps(n-2);
    }
}
