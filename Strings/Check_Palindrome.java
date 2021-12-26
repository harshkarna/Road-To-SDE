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

public class Check_Palindrome {

    //Approach 1
//    calculate reverse string and then compare with str

//    Approach 2
//    Below

    public static int check_palindrome(String str){
        int b=0;
        int e=str.length()-1;

        for(int i=0;i<=(str.length()/2);i++){
            if(str.charAt(b)!=str.charAt(e)){
                System.out.println("not palindrome");
                return 0;
            }
            b++;
            e--;
        }
        System.out.println("its a palindrome");
        return 1;
    }

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String str=s.nextLine();
        check_palindrome(str);


    }
}
