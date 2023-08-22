package com.Recursion.Striver;

public class CheckifPalindrome {

        public static boolean isPalindrome(String str) {
            // Base case: If the string is empty or has only one character, it's a palindrome
            if (str == null || str.length() <= 1) {
                return true;
            } else {
                // Compare first and last characters
                if (str.charAt(0) == str.charAt(str.length() - 1)) {
                    // Recursively check the substring obtained by removing the first and last characters
                    return isPalindrome(str.substring(1, str.length() - 1));
                } else {
                    return false;
                }
            }
        }

        public static void main(String[] args) {
            String str = "radar";
            System.out.println("Is \"" + str + "\" a palindrome? " + isPalindrome(str));

//            str = "hello";
//            System.out.println("Is \"" + str + "\" a palindrome? " + isPalindrome(str));
        }
    }


