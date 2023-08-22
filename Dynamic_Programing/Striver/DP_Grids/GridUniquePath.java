package com.Dynamic_Programing.Striver.DP_Grids;

import java.util.Arrays;

public class GridUniquePath {

    static int countWaysRec(int i, int j) {
        //base case
        if(i==0 && j == 0)
            return 1;
        if(i<0 || j<0)
            return 0;
        int up = countWaysRec(i-1,j);
        int left = countWaysRec(i,j-1);

        return up+left;

    }

    static int countWays(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return countWaysRec(m - 1, n - 1);

    }

    static int countWaysMemo(int i, int j, int[][] dp) {
        if(i==0 && j == 0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int up = countWaysMemo(i-1,j,dp);
        int left = countWaysMemo(i,j-1,dp);

        return dp[i][j] = up+left;

    }

    static int countWaysMe(int m, int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysMemo(m-1,n-1,dp);

    }

    static int countWaysTabu(int m, int n, int[][] dp) {

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){

                //base condition
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                int up=0;
                int left = 0;
                if(i>0)
                    up = dp[i-1][j];
                if(j>0)
                    left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }

    static int countWaysTab(int m, int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysTabu(m,n,dp);

    }




    public static void main(String[] args) {


    }
}
