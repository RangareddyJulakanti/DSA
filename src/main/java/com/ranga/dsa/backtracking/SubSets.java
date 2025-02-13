package com.ranga.dsa.backtracking;

import java.util.Arrays;

/**
 *       __  i=0
 *     /   \
 *  0       1  i=1
 *  /\      /\
 *00  01   10 11 i=2
 *
 */

public class SubSets {
    public static void main(String[] args) {
        int arraySize=2;
        int output[]=new int[arraySize];
        generateBooleanStrings(arraySize,0,output);
    }

    private static void generateBooleanStrings(int n, int i, int[] output) {
        if(i==n){
            System.out.println(Arrays.toString(output));
            return;
        }
        output[i]=0;
        generateBooleanStrings(n,i+1,output);
        output[i]=1;
        generateBooleanStrings(n,i+1,output);
        output[i]=2;
        generateBooleanStrings(n,i+1,output);

    }
}
