//Check Palindrome (recursive)
//
//        Check whether a given String S is a palindrome using recursion. Return true or false.
//        Input Format :
//        String S
//        Output Format :
//        'true' or 'false'
//        Constraints :
//        0 <= |S| <= 1000
//        where |S| represents length of string S.
//        Sample Input 1 :
//        racecar
//        Sample Output 1:
//        true
//        Sample Input 2 :
//        ninja
//        Sample Output 2:
//        false

package com.Recursion;

public class Check_Palindrome {

    public static boolean  checkPalindrome(String str ,int startIndex,int endIndex){

        if(startIndex>= endIndex){ //base case
            return true;
        }
        if(str.charAt(startIndex)!=str.charAt(endIndex)){
            return false;
        }

        boolean smallcase = checkPalindrome(str,startIndex+1,endIndex-1);
        return smallcase;
    }


    public static boolean helper(String str){

        return checkPalindrome(str,0,str.length()-1);
    }

    public static void main(String[] args) {
         String str="racecar";
        System.out.println(helper(str));


    }
}
