package com.ranga.dsa.bitmanipulation.day27;

public class CheckBit {
    public static void main(String[] args) {
        int N=21;
        boolean isCheckBit=checkBit(N,2);
        System.out.println(isCheckBit);
    }

    /**
     * Brute force approach
     * @param n
     * @param i
     * @return
     */
 /*   private static boolean checkBit(int n, int i) {
        int r=-1;
        for(int k=0;k<=i;k++){
            r=n%2;
            n=n/2;
        }
        if(r==1){
           return true;
        }
        else{
            return false;
        }
    }*/
    private static boolean checkBit(int n, int i) {
        if(((n>>i)&1)==1){
            return true;
        }else{
            return false;
        }
    }
}
