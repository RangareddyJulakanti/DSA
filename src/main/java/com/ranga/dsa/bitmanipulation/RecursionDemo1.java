package com.ranga.dsa.bitmanipulation;

public class RecursionDemo1 {
    public static void main(String[] args) {
        m1(10);
    }
    public static void  m1(int num){
        if(num==0){
            return;
        }
        m1(num-1);
        System.out.println(num);
    }
}
