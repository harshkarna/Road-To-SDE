//Remove X
//
//        Given a string, compute recursively a new string where all 'x' chars have been removed.
//        Input format :
//        String S
//        Output format :
//        Modified String
//        Constraints :
//        1 <= |S| <= 10^3
//        where |S| represents the length of string S.
//        Sample Input 1 :
//        xaxb
//        Sample Output 1:
//        ab
//        Sample Input 2 :
//        abc
//        Sample Output 2:
//        abc
//        Sample Input 3 :
//        xx
//        Sample Output 3:

package com.Recursion;

public class Remove_x {


    public static String replace_x(String str){
        if(str.length()==0){
            return str;
        }

        String smallcase=replace_x(str.substring(1));
        if(str.charAt(0)=='x'){
            return smallcase;
        }
        else{
            return str.charAt(0) +smallcase;
        }

    }
    public static void main(String[] args) {

        String str="xnsdzzkjxxkjkxx";
        System.out.println(replace_x(str));

    }
}
