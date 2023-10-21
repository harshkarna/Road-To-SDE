package com.Dynamic_Programing.Striver.DP_on_Strings;

import java.util.Arrays;

public class Longest_Common_Substring {


    static int longestCommonSubstringRecursion(String s1, String s2, int ind1, int ind2, int currentLength) {
        // Base case: If either string is empty, return the current length.
        if (ind1 < 0 || ind2 < 0)
            return currentLength;

        // If the characters at the current indices match.
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            // Continue the substring by reducing both indices and increasing the current length.
            return longestCommonSubstringRecursion(s1, s2, ind1 - 1, ind2 - 1, currentLength + 1);
        } else {
            // Reset the current length to 0 when characters don't match.
            // Continue searching for a common substring.
            int option1 = longestCommonSubstringRecursion(s1, s2, ind1, ind2 - 1, 0);
            int option2 = longestCommonSubstringRecursion(s1, s2, ind1 - 1, ind2, 0);
            return Math.max(currentLength, Math.max(option1, option2));
        }
    }

    static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return longestCommonSubstringRecursion(s1, s2, n - 1, m - 1, 0);
    }


    static int lcsTabulation(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        int ans=0;

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    ans = Math.max(ans, dp[ind1][ind2]);
                }
                else
                    dp[ind1][ind2] = 0 ;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s1= "abcjklp";
        String s2= "acjkp";

        System.out.println("The Length of Longest Common Substring is "+lcsTabulation(s1,s2));

    }
}
