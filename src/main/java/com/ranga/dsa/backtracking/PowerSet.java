package com.ranga.dsa.backtracking;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        generateSubSets(new int[]{1,2,3},0,new ArrayList<>());
    }
    public  static void generateSubSets(int[] input,int i,ArrayList<Integer> output){
        //baseCase
        if(i==input.length){
            System.out.println(output);
            return;
        }
        //1.include
        output.add(input[i]);
        generateSubSets(input,i+1,output);
        //2.exclude
        Integer x=input[i];
        output.remove(x);//backtracking step
        generateSubSets(input,i+1,output);
    }
}
