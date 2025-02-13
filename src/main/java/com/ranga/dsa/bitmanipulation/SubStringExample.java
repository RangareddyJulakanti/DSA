package com.ranga.dsa.bitmanipulation;

public class SubStringExample {
    public static void main(String[] args) {
        char[] a = {'x','y','s','m','a','r','t','p','q','r','s'};
        char[] b = {'s','m','a','r','t'};
       int startIndex=0;
       int endIndex=0;
       for(int i=0,j=0;i<a.length&j<b.length;i++){
           if(a[i]==b[0]){
               startIndex=i;
               j++;
           }
           else if(a[i]==b[j]){
               endIndex=i;
               j++;
           }
       }
        System.out.println(startIndex+"==="+endIndex);//2===6
        System.out.println(new String(a).substring(startIndex,endIndex+1));//smart
    }
}
