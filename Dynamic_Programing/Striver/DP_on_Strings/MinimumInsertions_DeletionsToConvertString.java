package com.Dynamic_Programing.Striver.DP_on_Strings;

import java.util.Arrays;

public class MinimumInsertions_DeletionsToConvertString {

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

    static int canYouMake(String str1, String str2){

        int n = str1.length();
        int m = str2.length();

        int k = lcsTabulation(str1,str2);

        return (n-k)+(m-k);
    }



    public static void main(String[] args) {


    }
}