package com.ranga.dsa.bitmanipulation.day27;

/**
 * Given N and I ,set the ith bit in N.
 * make it ith bit is 1
 * N=23     I:  4 3 2 1 0
 *              1 0 1 1 1
 *
 * I=3          1 1 1 1 1
 *
 * After setting 3rd bit is 1  N become (11111)base 2 means =31
 */

public class SetBit {
    public static void main(String[] args) {
        int N=23;
        setBitAndPrint(N,3);
    }

    private static void setBitAndPrint(int n, int i) {
        if(!checkBit(n,i)){
            n=n+(1<<i);
        }
        System.out.println(n);
    }
    private static boolean checkBit(int n, int i) {
        if(((n>>i)&1)==1){
            return true;
        }else{
            return false;
        }
    }
}
