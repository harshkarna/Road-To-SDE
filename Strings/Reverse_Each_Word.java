//Input: abc def ghi
//Output : cba fed ihg

package com.Strings;

public class Reverse_Each_Word {

    public static String reverseString(String str) {
        int wordStart=0;
        String finalString="";
        int i=0;
        for(i=0;i<str.length();i++){
            //reverse previous word before space
            if(str.charAt(i)==' '){
                int wordEnd=i;
                String reversedWord="";
                for(int j=wordStart;j<wordEnd;j++){
                    reversedWord=str.charAt(j)+reversedWord;
                }
                //adding to final string
                finalString=finalString+reversedWord+" ";
                wordStart=i+1;
            }
        }
        // for last word
        int wordEnd=str.length();
        String reversedWord="";
        for(int j=wordStart;j<wordEnd;j++){
            reversedWord=str.charAt(j)+reversedWord;
        }
        //adding to final string
        finalString=finalString+reversedWord;


        return finalString;
    }

    public static void main(String[] args) {
        String str = "abc def ghi";
        System.out.println(reverseString(str));

    }

}