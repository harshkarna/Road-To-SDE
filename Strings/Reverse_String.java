package com.Strings;

import java.util.Scanner;

public class Reverse_String {

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String str=s.nextLine();
        String str1="";
        int n = str.length()-1;

//
//        iterating from last
//        for(int i=str.length()-1;i>=0;i--){
//            str1=str1+str.charAt(i);
//        }


//      Iterating from beginning
        for(int i=0;i<str.length();i++){
            str1=str.charAt(i)+str1;
        }

        System.out.print(str1);

    }
}
