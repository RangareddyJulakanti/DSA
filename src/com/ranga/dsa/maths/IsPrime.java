package com.ranga.dsa.maths;

public class IsPrime {
    public static void main(String[] args) {
      for(int i=1;i<30;i++){
          System.out.println("i=="+i +"--"+isPrime(i));
      }
    }
    public static boolean isPrime(int n){
        if(n==0||n==1){
            return false;
        }
        for(int i=2;i*i<n-1;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
