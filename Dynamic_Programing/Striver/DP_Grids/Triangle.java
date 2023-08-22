package com.Dynamic_Programing.Striver.DP_Grids;

import java.util.Arrays;

public class Triangle {

    static int minimumPathSumRec(int i, int j, int[][] triangle,int n) {
        //base case
        if(i==n-1) return triangle[i][j];

        int down = triangle[i][j]+minimumPathSumRec(i+1,j,triangle,n);
        int diagonal = triangle[i][j]+minimumPathSumRec(i+1,j+1,triangle,n);

        return Math.min(down, diagonal);

    }

    static int minimumPathSumRec(int[][] triangle, int n){

        return minimumPathSumRec(0,0,triangle,n);
    }


    static int minimumPathSumMemo(int i, int j, int[][] triangle,int n,int[][] dp) {

        if(dp[i][j]!=-1)
            return dp[i][j];

        if(i==n-1) return triangle[i][j];

        int down = triangle[i][j]+minimumPathSumMemo(i+1,j,triangle,n,dp);
        int diagonal = triangle[i][j]+minimumPathSumMemo(i+1,j+1,triangle,n,dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    static int minimumPathSum(int[][] triangle, int n){
        int dp[][]=new int[n][n];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return minimumPathSumMemo(0,0,triangle,n,dp);
    }

    static int minimumPathSumTab(int[][] triangle, int n){

        int dp[][]= new int[n][n];

        //computing the base row , last row
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for (int j = 0; j <= i; j++) {

                int down = triangle[i][j]+dp[i+1][j];
                int diagonal = triangle[i][j]+dp[i+1][j+1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];

    }

    static int minimumPathSumSpaceOptimised(int[][] triangle, int n){

        int front[] = new int[n];
        int cur[] = new int[n];

        for(int j=0;j<n;j++){
            front[j] = triangle[n-1][j];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){

                int down = triangle[i][j]+front[j];
                int diagonal = triangle[i][j]+front[j+1];

                cur[j] = Math.min(down, diagonal);
            }
            front=cur;
        }

        return front[0];

    }

    public static void main(String[] args) {


        int triangle [][] = {{2},{3,4},{6,5,7},{4,1,8,3}};

        int n = triangle.length;

        System.out.println(minimumPathSumTab(triangle,n));


    }
}
