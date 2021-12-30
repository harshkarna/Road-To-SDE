//Reverse Each Word
//
//        Aadil has been provided with a sentence in the form of a string as a function parameter. The task is to implement a function so as to print the sentence such that each word in the sentence is reversed.
//        Example:
//        Input Sentence: "Hello, I am Aadil!"
//        The expected output will print, ",olleH I ma !lidaA".
//        Input Format:
//        The first and only line of input contains a string without any leading and trailing spaces. The input string represents the sentence given to Aadil.
//        Output Format:
//        The only line of output prints the sentence(string) such that each word in the sentence is reversed.
//        Constraints:
//        0 <= N <= 10^6
//        Where N is the length of the input string.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        Welcome to Coding Ninjas
//        Sample Output 1:
//        emocleW ot gnidoC sajniN
//        Sample Input 2:
//        Always indent your code
//        Sample Output 2:
//        syawlA tnedni ruoy edoc
//

package com.Strings;

public class Reverse_Each_Word_1 {

    public static String reverse_each_word(String str){
        String finalstring="";
        int start=0;
        int i=0;
        String reversed_Word="";
        for(i=0;i<str.length();i++){
             reversed_Word="";
            if(str.charAt(i)==' '){
                int end=i;
                for(int j=start;j<end;j++) {
                    reversed_Word = str.charAt(j) + reversed_Word;
                }
                //adding to final string
                finalstring=finalstring+reversed_Word+" ";
                start=i+1;
            }

        }
//        last element
        int end=str.length();
        for(int j=start;j<end;j++){
            reversed_Word=str.charAt(j)+reversed_Word;
        }
        //adding to final string
        finalstring=finalstring+reversed_Word;
        return finalstring;
    }

    public static void main(String[] args) {

        String str="Welcome to Coding Ninjas";
        String ans= reverse_each_word(str);
        System.out.println(ans);

    }
}
