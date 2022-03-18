//String to Integer
//
//        Write a recursive function to convert a given string into the number it represents.
//        That is input will be a numeric string that contains only numbers, you need to convert
//        the string into corresponding integer and return the answer.
//        Input format :
//        Numeric string S (string, Eg. "1234")
//        Output format :
//        Corresponding integer N (int, Eg. 1234)
//        Constraints :
//        0 <= |S| <= 9
//        where |S| represents length of string S.
//        Sample Input 1 :
//        1231
//        Sample Output 1 :
//        1231
//        Sample Input 2 :
//        12567
//        Sample Output 2 :
//        12567

package com.Recursion;

public class String_to_Integer {

    public static int str_to_int(String str){
        if(str.length()==0){
            return 0;
        }

        double smallcase =str_to_int(str.substring(1));
        double ans=str.charAt(0)-'0';
        return (int) (ans * Math.pow(10,str.substring(1).length()) + smallcase);

    }

    public static void main(String[] args) {
      String str="123479304";
      System.out.println(str_to_int(str));

    }
}
