//Replace pi (recursive)
//
//        Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
//        Sample Input 1 :
//        xpix
//        Sample Output :
//        x3.14x
//        Sample Input 2 :
//        pipi
//        Sample Output :
//        3.143.14
//        Sample Input 3 :
//        pip
//        Sample Output :
//        3.14p

package com.Recursion;

public class Replace_pi {

    public static String replace_pi(String str){
        if(str.length()==1){
            return str;
        }

        String smallcase=replace_pi(str.substring(1));

        if(str.charAt(0)=='p' && str.charAt(1)=='i'){
            return "3.14" +smallcase.substring(1);
        }
        else {
            return str.charAt(0)+smallcase;
        }

//        if(str.charAt(0)=='p' && smallcase.charAt(0)=='i'){
//            return "3.14" +smallcase.substring(1);
//        }
//        else {
//            return str.charAt(0)+smallcase;
//        }
    }


    public static void main(String[] args) {

        String str="xpix";
        System.out.println(replace_pi(str));


    }

}
