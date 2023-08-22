package com.Dynamic_Programing.Striver.DP_Grids;

import java.util.Arrays;

public class MinimumPathSum {


    static int minSumPathRecu(int i, int j, int[][] matrix) {
        if(i==0 && j == 0)
            return matrix[0][0];
        if(i<0 || j<0)
            return (int)Math.pow(10,9);

        int up = matrix[i][j]+minSumPathRecu(i-1,j,matrix);
        int left = matrix[i][j]+minSumPathRecu(i,j-1,matrix);

        return  Math.min(up,left);

    }

    static int minSumPathRec(int n, int m, int[][] matrix){

        return minSumPathRecu(n-1,m-1,matrix);

    }

    static int minSumPathMemo(int i, int j, int[][] matrix, int[][] dp) {
        if(i==0 && j == 0)
            return matrix[0][0];
        if(i<0 || j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j]!=-1) return dp[i][j];

        int up = matrix[i][j]+minSumPathMemo(i-1,j,matrix,dp);
        int left = matrix[i][j]+minSumPathMemo(i,j-1,matrix,dp);

        return dp[i][j] = Math.min(up,left);

    }

    static int minSumPathMemo1(int n, int m, int[][] matrix){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return minSumPathMemo(n-1,m-1,matrix,dp);

    }

    public static int minPathSumTab(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dp[][]=new int[n][m];

        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{

                    int up = grid[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);

                    int left = grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);

                    dp[i][j] = Math.min(up,left);
                }
            }
        }

        return dp[n-1][m-1];


    }

    public static void main(String[] args) {

        int matrix[][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSumTab(matrix));
    }

}
