package com.ranga.dsa.backtracking;

public class SubSetExample {
    public static void main(String[] args) {
         //input AB
        //output "","A","B" ,"AB"
        /**
         *  ""---------""-----exclude
         *             "C"---include
         *
         *  "A" --------"A"-----exclude
         *              "AC"-------include
         *
         *  "B"----------"B"------exclude
         *               "BC"------include
         *  "AB"----------"AB"------exclude
         *                 "ABC-----include
         *
         */
        String str="ABC";
        generateSubSet(str,"",0);
    }

    private static void generateSubSet(String str, String cur, int i) {
        if(i==str.length()){
            System.out.println(cur);
            return;
        }
        generateSubSet(str,cur,i+1);

        generateSubSet(str,cur+str.charAt(i),i+1);
    }
}
