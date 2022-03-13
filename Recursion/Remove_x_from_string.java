package com.Recursion;

public class Remove_x_from_string {

    //My own favourite

    public static String remove_char(String str, char ch, int startIndex){
        if(startIndex==str.length()){
            return "";
        }
        String smallcase=remove_char(str,ch,startIndex+1);
        if(str.charAt(startIndex)==ch){
            return smallcase;
        }
        else{
            smallcase=str.charAt(startIndex)+smallcase;
            return smallcase;
        }

    }

    public static String remove_char(String str, char ch){

        return remove_char(str,ch,0);
    }

        public static void main(String[] args) {

        String str="xqewxxxewrwerxerwerewx";
        char ch='x';
        System.out.println(remove_char(str,ch));

    }
}
