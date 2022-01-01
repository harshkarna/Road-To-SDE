//Check Palindrome
//
//        Given a string, determine if it is a palindrome, considering only alphanumeric characters.
//        Palindrome
//        A palindrome is a word, number, phrase, or other sequences of characters which read the same backwards and forwards.
//        Example:
//        If the input string happens to be, "malayalam" then as we see that this word can be read the same as forward and backwards, it is said to be a valid palindrome.
//
//        The expected output for this example will print, 'true'.
//        From that being said, you are required to return a boolean value from the function that has been asked to implement.
//        Input Format:
//        The first and only line of input contains a string without any leading and trailing spaces. All the characters in the string would be in lower case.
//        Output Format:
//        The only line of output prints either 'true' or 'false'.
//        Note:
//        You are not required to print anything. It has already been taken care of.
//        Constraints:
//        0 <= N <= 10^6
//        Where N is the length of the input string.
//
//        Time Limit: 1 second
//        Sample Input 1 :
//        abcdcba
//        Sample Output 1 :
//        true
//        Sample Input 2:
//        coding
//        Sample Output 2:
//        false
package com.Strings;

import java.util.Scanner;

//Solved by Char array
public class Check_Palindrome_NonCaseSensitive {
    public static char toLowerCase(char ch){
        if(ch>='a' && ch<='z'){
            return ch;
        }
        else{
            char temp= (char) (ch-'A'+'a');//ascii values
            return temp;
        }
    }


    public static boolean check_palindrome(char[] ch){
        int s=0;
        int e=ch.length-1;

        while(s<=e){
            if(toLowerCase(ch[s])!=toLowerCase(ch[e])){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String str=s.nextLine();
        char ch[] =str.toCharArray();
        System.out.println(check_palindrome(ch));


    }
}
