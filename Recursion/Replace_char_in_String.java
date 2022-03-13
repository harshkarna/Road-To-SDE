//Replace Character Recursively
//
//        Given an input string S and two characters c1 and c2,
//        you need to replace every occurrence of character c1 with character c2 in the given string.
//        Do this recursively.
//        Input Format :
//        Line 1 : Input String S
//        Line 2 : Character c1 and c2 (separated by space)
//        Output Format :
//        Updated string
//        Constraints :
//        1 <= Length of String S <= 10^6
//        Sample Input :
//        abacd
//        a x
//        Sample Output :
//        xbxcd

package com.Recursion;

public class Replace_char_in_String {

    public static String replace_char(String str, char a, char x){

        if(str.length()==0){
            return str;
        }

        String smallcase=replace_char(str.substring(1),a,x);
        if(str.charAt(0)!=a){
            return str.charAt(0)+smallcase;
        }
        else if(str.charAt(0)==a){
            return x+smallcase;
        }
        else{
            return str;
        }
    }

    public static void main(String[] args) {

        String str="abaacd";
        char a ='a';
        char x ='x';

        System.out.println(replace_char(str, a,x));
    }


}
