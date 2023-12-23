package com.Dynamic_Programing.Striver.MCM_Partition_DP;

import java.util.Arrays;

public class PalindromePartioning_2 {

    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static int Recursion_f(int i, int n, String str) {
        // Base case:
        if (i == n) return 0;

        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + Recursion_f(j + 1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    static int palindromePartitioning(String str) {
        int n = str.length();
        return Recursion_f(0, n, str) - 1;
    }

    static boolean isPalindrome_M(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static int Memo_f(int i, int n, String str, int[] dp) {
        // Base case:
        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        // String[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome_M(i, j, str)) {
                int cost = 1 + Memo_f(j + 1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    static int M_palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Memo_f(0, n, str, dp) - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);

    }
}
