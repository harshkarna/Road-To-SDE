package com.Recusrion_Part2;

public class Print_Subsequences {


    public static void printSubsequences(String input, String outputSoFar){
        if(input.length()==0){
            System.out.println(outputSoFar);
            return;
        }

        //we choose not to include first character
        printSubsequences(input.substring(1),outputSoFar);

        //we choose to include first character
        printSubsequences(input.substring(1),outputSoFar + input.charAt(0));
    }

    public static void printSubsequences(String input){
        printSubsequences(input,"");
    }


    public static void main(String[] args) {

        printSubsequences("xyz");
    }
}
