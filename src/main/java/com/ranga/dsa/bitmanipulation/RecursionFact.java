package com.ranga.dsa.bitmanipulation;

public class RecursionFact {
    public static void main(String[] args) {
       int value= pow(2,10);
        System.out.println(value);
    }
    public static int pow(int a ,int n){
        if(a==1){
            return 1;
        }
        if(n==0){
            return 1;
        }
        int p=pow(a,n/2);
        if(n%2==0){
            return p*p;
        }else{
            return a*p*p;
        }
    }
}
