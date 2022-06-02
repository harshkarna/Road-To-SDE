//Remove Duplicates Recursively
//
//        Given a string S, remove consecutive duplicates from it recursively.
//        Input Format :
//        String S
//        Output Format :
//        Output string
//        Constraints :
//        1 <= |S| <= 10^3
//        where |S| represents the length of string
//        Sample Input 1 :
//        a abccba
//        Sample Output 1 :
//        abcba
//        Sample Input 2 :
//        xxxyyyzwwzzz
//        Sample Output 2 :
//        xyzwz

package com.Recursion;

public class Remove_duplicates_in_String {

    public static String remove_dupes(String str){
        if(str.length()<=1){
            return str;
        }

        String smallcase=remove_dupes(str.substring(1));
        if(str.charAt(0)==str.charAt(1)){
            return smallcase;
        }
        else{
            return str.charAt(0)+smallcase;
        }

    }

    public static void main(String[] args) {

        String str="aakkkbccba";
        System.out.println(remove_dupes(str));


    }
}
