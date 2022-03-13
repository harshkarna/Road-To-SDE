package com.Recursion;

public class Remove_x_from_string_1 {

    //My own favourite

    public static String remove_char(String str, char ch){
        if(str.length()==0){  //base case
            return str;
        }

        String ans="";
        if(str.charAt(0)!=ch){
            ans=ans+str.charAt(0);
        }
        String smallcase=remove_char(str.substring(1),ch);
        return ans+smallcase;

    }

        public static void main(String[] args) {

        String str="xbxacx";
        char ch='x';
        System.out.println(remove_char(str,ch));

    }
}
