package com.ranga.backtracking;

public class EggDropping
{
  public static int eggDrop(int eggs, int floors) 
  {
    // If there are no eggs, then there can't be any tries
    if (eggs <= 0)
      return 0;
    
    // If there are no floors, then no trials needed. OR if there is 
    // one floor, one trial needed.
    if (floors == 1 || floors == 0)
      return floors;

    // We need k trials for one egg and k floors 
    if (eggs == 1)
      return floors;

    int min = Integer.MAX_VALUE;
    int x, res;

    // Consider all droppings from 1st floor to kth floor and 
    // return the minimum of these values plus 1. 
    for (x = 1; x <= floors; x++) {
      res = Math.max(eggDrop(eggs - 1, x - 1), eggDrop(eggs, floors - x));
    if (res < min)
        min = res;
    }

    return min + 1;
  }
 
  public static void main(String args[]) 
  {
    int eggs = 2, floors = 10;
    System.out.println("With " + eggs + " eggs and " + floors + " floors, the minimum number of trials in worst are: " + eggDrop(eggs, floors));
  }
};