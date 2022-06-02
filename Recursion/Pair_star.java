//Pair star
//
//        Given a string S, compute recursively a new string where identical chars that are adjacent in
//        the original string are separated from each other by a "*".
//        Input format :
//        String S
//        Output format :
//        Modified string
//        Constraints :
//        0 <= |S| <= 1000
//        where |S| represents length of string S.
//        Sample Input 1 :
//        hello
//        Sample Output 1:
//        hel*lo
//        Sample Input 2 :
//        aaaa
//        Sample Output 2 :
//        a*a*a*a


package com.Recursion;

public class Pair_star {

    public static String add_star(String str){
        if(str.length()==1){
            return str;
        }

        String smallcase=add_star(str.substring(1));
        if(str.charAt(0)==str.charAt(1)){
            return str.charAt(0)+"*"+smallcase;
        }
        else{
            return str.charAt(0)+smallcase;
        }
    }


    public static void main(String[] args) {


        String str="lllll";
        System.out.println(add_star(str));


    }
}
