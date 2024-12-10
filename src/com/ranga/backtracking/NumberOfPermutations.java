package com.ranga.backtracking;

public class NumberOfPermutations {
    public static void main(String[] args) { 
        printValues(0,3,new int[3]);
    }

    private static void printValues(int i, int index, int[] arr) {
      if(i==index){
          for(int j=0;j<index;j++){
              System.out.print(arr[j]);
          }
          return;
      }
      arr[i]=1;
      printValues(i+1,index,arr);
        System.out.println("\n");
      arr[i]=2;
      printValues(i+1,index,arr);
    }
}
