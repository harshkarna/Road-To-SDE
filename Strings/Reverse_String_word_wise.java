//Reverse String Word Wise
//
//        Reverse the given string word wise. That is, the last word in given string should come at 1st place,
//        last second word at 2nd place and so on. Individual words should remain as it is.
//        Input format
//        String in a single line
//        Output format
//        Word wise reversed string in a single line
//        Constraints
//        0 = S = 10^7
//        where S represents the length of string, S.
//        Sample Input 1
//        Welcome to Coding Ninjas
//        Sample Output 1
//        Ninjas Coding to Welcome
//        Sample Input 2
//        Always indent your code
//        Sample Output 2
//        code your indent Always
//

package com.Strings;

public class Reverse_String_word_wise {

    public static String Reverse_String_word_wise(String str){
        String finalString="";
        int n =str.length();
        int wordEnd=n-1;
        int i=0;
        //traversing from last
        for(i=n-1;i>=0;i--){
            if(str.charAt(i)==' '){
                int wordStart=i+1;
                String reversedWord="";
                for(int j=wordStart;j<=wordEnd;j++){
                    reversedWord=reversedWord+str.charAt(j);
                }
                //adding to final String
                finalString=finalString+reversedWord+ " ";
                wordEnd=i-1;
            }
        }
       // for last word
        int wordStart=0;
        String reversedWord="";
        for(int j=wordStart;j<=wordEnd;j++){
            reversedWord=reversedWord+str.charAt(j);
        }
        //adding to final String
        finalString=finalString+reversedWord+ " ";
        return finalString;
    }


    public static void main(String[] args) {
        String str = "Welcome to Coding Ninjas";
        System.out.println(Reverse_String_word_wise(str));

    }
}
