package com.ranga.dsa.arraysAndMaths;

public class JosephusProblem {
    public static void main(String[] args) {
        int lastMan=lastManStanding(16);
        System.out.println(lastMan);
    }

    private static int lastManStanding(int n) {
        int y=nearestPowerOf2(n);
        int kills=n-y;
        return 1+2*kills;
    }

    private static int nearestPowerOf2(int n) {
        int res=1;
        while(res<=n){
            res=res*2;
        }
        return res/2;
    }

}
