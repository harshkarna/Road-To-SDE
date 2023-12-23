package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    // Custom comparison function for sorting strings by length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    private static boolean compare(String word, String word1) {
        if (word.length() != word1.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < word.length()) {
            if (second < word1.length() && word.charAt(first) == word1.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        if( first == word.length() && second == word1.length()){
            return true;
        }
        else return false;

    }

    public  static int  lengthOfLITabulation(String[] words) {
        int n = words.length;

        // Sort the array by string length
        Arrays.sort(words,comp);

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int max=-1;
        for(int current=1;current<n;current++){
            for(int prev_index=0;prev_index<current;prev_index++){
                if (compare(words[current], words[prev_index]) && 1 + dp[prev_index] > dp[current]) {
                    dp[current] = 1 + dp[prev_index];
                }
            }
            max=Math.max(max,dp[current]);
        }
        return max;
    }


    public static void main(String[] args) {

        String[] words = {"abcd","dbqca"};

        System.out.println("The length of the longest string chain is: " + lengthOfLITabulation(words));

    }
}
