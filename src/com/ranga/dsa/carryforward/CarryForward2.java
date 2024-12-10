package com.ranga.dsa.carryforward;

/**
 * Given a String of lower case char return a pair of indexes(i,j)
 * Ex: String s="a b e g a g"
 *               0 1 2 3 4 5
 *
 *              Ans: (0,3) (0,5) (4,5) //3 pairs
 */

public class CarryForward2 {

    public static void main(String[] args) {
        String s="abegag";
        char[] chars=s.toCharArray();
        int countOfPairs=0;
        for(int i=0;i<chars.length;i++){
            for(int j=i;j<chars.length;j++){
                if(chars[i]=='a'&&chars[j]=='g'){
                    System.out.println("A index == "+i+" B index == "+j);
                    countOfPairs++;
                }
            }
        }
        System.out.println(countOfPairs);
        //T(C) =O(n)^2 ,S(C): O(n);

        /**
         * Observation: Every 'g' will make pair with all the 'a's to the left
         * Ex: String s="a b e g a g"
         *               0 1 2 3 4 5
         *    a_count= 1 1 1 1 2 2
         *    ans    = 0 0 0 1 1 3  when we found 'g' we have to do addition of a_count+ans
         *
         */
        int a_count=0;
        int ans=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='a'){
                a_count++;
            }
            if(chars[i]=='g'){
                ans=ans+a_count;
            }
        }
        System.out.println(ans);


    }

}
