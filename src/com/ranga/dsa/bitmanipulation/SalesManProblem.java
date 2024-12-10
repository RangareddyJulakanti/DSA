package com.ranga.dsa.bitmanipulation;

public class SalesManProblem {

    public static int minCost(int dist[][],int n,int currentCity,int visited){
        //all cities are visited or not
        if(visited==(1<<n)-1){
           return dist[currentCity][0];
        }

        int cost=Integer.MAX_VALUE;

        for(int city=0;city<n;city++){
            //means the city is not yet visited
            if((visited&(1<<city))==0){

                int currentPathCost=dist[currentCity][city]+minCost(dist,n,city,visited|(1<<city));
                cost=Math.min(cost,currentPathCost);
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int dist[][]={
                {0,20,42,25},
                {20,0,30,34},
                {42,30,0,18},
                {25,34,10,0}
        };
       int minCost= minCost(dist,4,0,1);//here visited means 0001 (visited A)
        //0 means A,1 means B,2 Means C 3 means D
        System.out.println(minCost);
    }

}
