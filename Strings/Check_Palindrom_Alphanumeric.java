//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
// removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
//
//        Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//        Example 1:
//
//        Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
//        Example 2:
//
//        Input: s = "race a car"
//        Output: false
//        Explanation: "raceacar" is not a palindrome.


package com.Strings;

public class Check_Palindrom_Alphanumeric {

    // remove unneccessaru character
    public static boolean removeextarchar(char ch){

        if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')|| (ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }

    //convert to lower case
    public static char toLowerCase(char ch){

        if(ch>='a' && ch<='z' || ch>='0' && ch<='9'){
            return ch;
        }
        else{
            char temp= (char) (ch-'A'+'a');//ascii values
            return temp;
        }
    }

    //check palindrome
    public static boolean check_palindrome(String str){
        int s=0; //starting pointer3
        int e=str.length()-1; //ending pointer
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                System.out.println("not palindrome");
                return false;
            }
            s++;
            e--;
        }
        System.out.println("its a palindrome");
        return true;
        }

    public static void isPalindrome(String str){
        String temp=""; // updated string (to remove all faltu character)
        String tolower=""; //update string to store all lower case

        //faltu character
        for(int i=0;i<str.length();i++){
            if(removeextarchar(str.charAt(i))){
                temp=temp+str.charAt(i);
            }
        }
//        System.out.println(temp);

        //temp string ko lower case mein kardo
        for(int i=0;i<temp.length();i++){
            tolower=tolower+toLowerCase(temp.charAt(i));
        }

//        System.out.println(tolower);

        // send this temp to check palindrome
        check_palindrome(tolower);

    }

    public static void main(String[] args) {

        String str="N2 i&nJA?a& jnI2n";
        String str1="N1oo1n";
        isPalindrome(str1);


    }
}
