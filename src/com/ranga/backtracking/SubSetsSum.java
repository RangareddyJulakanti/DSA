package com.ranga.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubSetsSum {
    static int[] source={5,-2,9,2};
    static int target=7;
    public static void main(String[] args) {

        printSubSetSum(0,0, new ArrayList<>());
    }

    private static boolean  printSubSetSum(int pointer, int sum_till_now,List<Integer> values) {
        if(pointer==source.length){
            if(sum_till_now==target){
                System.out.println(sum_till_now+"---"+values);
                extracted(values);
                return true;
            }
            return false;
        }
        values.add(source[pointer]);
       boolean isMatched = printSubSetSum(pointer+1,sum_till_now+source[pointer],values);
        if (!isMatched) {
            values.removeIf(e -> e == source[pointer]);
            isMatched=  printSubSetSum(pointer+1,sum_till_now, values);
        }
        return isMatched;

    }

    private static List<Integer> extracted(List<Integer> removables) {
        List<Integer> removedElements= Arrays.stream(source).boxed().collect(Collectors.toList());
        removedElements.removeAll(removables);
        System.out.println(removedElements);
        source= removedElements.stream()
                .mapToInt(i->i)
                .toArray();
        return removedElements;
    }
}
