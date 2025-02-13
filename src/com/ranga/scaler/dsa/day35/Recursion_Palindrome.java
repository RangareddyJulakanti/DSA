package com.ranga.scaler.dsa.day35;

/**
 *   String a="a b c d c b a";
 *             0 1 2 3 4 5 6
 *
 *             s=2-->3        s==e
 *             e=4-->3
 *
 *      String a="a b c  c b a";
 *  *             0 1 2  3 4 5
 *  *
 *  *             s=2-->3   s>e
 *  *             e=3-->2
 *
 *  s=0,e=1
 *  "aa"
 *  s=0;e=0;
 *  "a"
 */
public class Recursion_Palindrome {
    public static void main(String[] args) {
        String a="abcdcba";

        boolean isPalindrome=isPalindrome(a,0,a.length()-1);
        System.out.println(isPalindrome);
    }


    private static boolean isPalindrome(String str,int s,int e) {

        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
                System.out.println("Here starting char is ==  "+str.charAt(s) +" ending char is "+str.charAt(e));
                return false;
            }else {
                s = s + 1;
                e = e - 1;
            }
        }
        return true;
      /*  //assumption [s:e] chars are same then it will return true
        //base condition
        if(s>=e) //if str length is odd then s==e, even s>e
        {
            return true;
        }
        //main logic
        if(str.charAt(s)!=str.charAt(e)){
            return false;
        }else{
            return isPalindrome(str,s+1,e-1);
        }*/
    }
}
