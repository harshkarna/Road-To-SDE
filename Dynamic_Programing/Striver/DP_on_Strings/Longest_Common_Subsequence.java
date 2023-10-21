package com.Dynamic_Programing.Striver.DP_on_Strings;

import java.util.Arrays;

public class Longest_Common_Subsequence {

    static int lcsRecursion(String s1, String s2, int ind1, int ind2){

        if(ind1<0 || ind2<0)
            return 0;
        //if index is equal then return that 1 occurrence and rest recursion will do
        if(s1.charAt(ind1) == s2.charAt(ind2))
            return  1 + lcsRecursion(s1,s2,ind1-1,ind2-1);

        else
            //if index is not equal , then first shrrink 1st string and then 2nd string by 1 , and take the max out of both
            return  0 + Math.max(lcsRecursion(s1,s2,ind1,ind2-1), lcsRecursion(s1,s2,ind1-1,ind2));

    }


    static int lcsR(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        return lcsRecursion(s1,s2,n-1,m-1);
    }

    static int lcsUtilMemo(String s1, String s2, int ind1, int ind2, int[][] dp){

        if(ind1<0 || ind2<0)
            return 0;

        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcsUtilMemo(s1,s2,ind1-1,ind2-1,dp);

        else
            return dp[ind1][ind2] = 0 + Math.max(lcsUtilMemo(s1,s2,ind1,ind2-1,dp), lcsUtilMemo(s1,s2,ind1-1,ind2,dp));

    }


    static int lcsM(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n][m];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return lcsUtilMemo(s1,s2,n-1,m-1,dp);
    }

    /*Steps to convert Recursive Solution to Tabulation one.
        To convert the memoization approach to a tabulation one, create a dp array with the +1 as done in memoization.

        Initialization: Shifting of indexes

        In the recursive logic, we set the base case to if(ind1<0 || ind2<0) but we can’t set the dp array’s
        index to -1. Therefore a hack for this issue is to shift every index by 1 towards the right.

        Therefore, now the base case will be if(ind1==0 || ind2==0).
        Similarly, we will implement the recursive code by keeping in mind the shifting of indexes, therefore
        S1[ind1] will be converted to S1[ind1-1]. Same for others.
        At last we will print dp[N][M] as our answer.

        */
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

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {

    }
}
