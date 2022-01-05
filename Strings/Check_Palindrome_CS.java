//You are given a string 'S'. Your task is to check whether the string is palindrome or not. For checking palindrome, consider alphabets and numbers only and ignore the
//        symbols and whitespaces.
//        Note :
//        String 'S' is NOT case sensitive.
//        Example :
//        Let S = “c1 O$d@eeD o1c”.
//        If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “c1odeedo1c”,
//        which is a palindrome. Hence, the given string is also a palindrome.
//        Input Format :
//        The very first line of input contains an integer 'T' denoting the number of test cases.
//
//        The first line of every test case contains the string 'S'.
//        Output Format :
//        For each test case, print “Yes” if 'S' is a palindrome, and “No” otherwise.
//
//        Print the output of each test case in a separate line.
//        Note :
//        You do not need to print anything, it has already been taken care of. Just implement the given function.
//        Follow Up :
//        Can you solve the problem using O(1) space complexity?
//        Constraints :
//        1 <= T <= 100
//        1 <= Length(S) <= 10^4
//
//        Where 'T' denotes the number of test cases and 'S' denotes the given string.
//
//        Time Limit : 1 sec
//        Sample Input 1 :
//        2
//        N2 i&nJA?a& jnI2n
//        A1b22Ba
//        Sample Output 1 :
//        Yes
//        No
//        Explanation 1 :
//        For the first test case, S = “N2 i&nJA?a& jnI2n”. If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “n2injaajni2n”, which is a palindrome. Hence, the given string is also a palindrome.
//
//        For the second test case, S = “A1b22Ba”. If we ignore the special characters, whitespaces and convert all uppercase letters to lowercase, we get S = “a1b22ba”, which is not a palindrome. Hence, the given string is not a palindrome.
//        Sample Input 2 :
//        3
//        codingninjassajNiNgNidoc
//        5?36@6?35
//        aaBBa@
//        Sample Output 2 :
//        Yes
//        Yes
//        No
//

package com.Strings;

public class Check_Palindrome_CS {

    public static boolean isPalindrome(String str){
        int s=0;
        int e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
                }
            s++;
            e--;
            }
        return true;
        }

    public static void checkPalindrome(String str){
        String temp=""; //to store string with removed extra characters

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z')||(ch>='0'&& ch<='9')){
                temp=temp+ch;
            }
        }
        System.out.println(temp);

        temp=temp.toLowerCase();
        System.out.println(temp);

        if(isPalindrome(temp)){
            System.out.println("Its a Palindrome");
        }
        else{
            System.out.println("its Not a Palindrome");
        }
    }

    public static void main(String[] args) {
         String str ="N2 i&nJA?a& jnI2n";
//         String str1 ="Noon";

        checkPalindrome(str);
    }
}
