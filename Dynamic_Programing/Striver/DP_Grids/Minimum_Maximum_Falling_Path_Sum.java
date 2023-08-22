package com.Dynamic_Programing.Striver.DP_Grids;

import java.util.Arrays;

public class Minimum_Maximum_Falling_Path_Sum {

    static int getMaxPathSumRec(int i, int j, int m, int[][] matrix){

        // Base Conditions
        if(j<0 || j>=m)
            return (int)Math.pow(-10,9);
        if(i==0)
            return matrix[0][j];

        int up = matrix[i][j] + getMaxPathSumRec(i-1,j,m,matrix);
        int leftDiagonal = matrix[i][j] + getMaxPathSumRec(i-1,j-1,m,matrix);
        int rightDiagonal = matrix[i][j] + getMaxPathSumRec(i-1,j+1,m,matrix);

        return  Math.max(up,Math.max(leftDiagonal,rightDiagonal));

    }

    static int getMaxPathSumRe(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            int ans = getMaxPathSumRec(n-1,j,m,matrix);
            maxi = Math.max(maxi,ans);
        }

        return maxi;
    }


    static int getMaxPathSumMemo(int i, int j, int m, int[][] matrix,int[][] dp){

        // Base Conditions
        if(j<0 || j>=m)
            return (int)Math.pow(-10,9);
        if(i==0)
            return matrix[0][j];

        if(dp[i][j]!=-1) return dp[i][j];

        int up = matrix[i][j] + getMaxPathSumMemo(i-1,j,m,matrix,dp);
        int leftDiagonal = matrix[i][j] + getMaxPathSumMemo(i-1,j-1,m,matrix,dp);
        int rightDiagonal = matrix[i][j] + getMaxPathSumMemo(i-1,j+1,m,matrix,dp);

        return dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));

    }

    static int getMaxPathSum(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][]= new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            int ans = getMaxPathSumMemo(n-1,j,m,matrix,dp);
            maxi = Math.max(maxi,ans);
        }

        return maxi;
    }

    static int getMaxPathSumtaB(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(-10,9);

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(-10,9);

                dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));

            }
        }

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }

    static int getMaxPathSumtaBmIN(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(10,9);

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(10,9);

                dp[i][j] = Math.min(up, Math.min(leftDiagonal,rightDiagonal));

            }
        }

        int mini = Integer.MAX_VALUE;

        for(int j=0; j<m;j++){
            mini = Math.min(mini,dp[n-1][j]);
        }

        return mini;
    }

    /*int getMaxPathSumSpaceOptimised(vector<vector<int> > &matrix){

        int n = matrix.size();
        int m = matrix[0].size();

        vector<int> prev(m,0), cur(m,0);

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            prev[j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + prev[j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += prev[j-1];
                else leftDiagonal += -1e9;

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += prev[j+1];
                else rightDiagonal += -1e9;

                cur[j] = max(up, max(leftDiagonal,rightDiagonal));

            }

            prev = cur;
        }

        int maxi = INT_MIN;

        for(int j=0; j<m;j++){
            maxi = max(maxi,prev[j]);
        }

        return maxi;

    }
    */



    public static void main(String[] args) {

        int matrix[][] = {{2,1,3},
                         {6,5,4},
                         {7,8,9}};
        System.out.println(getMaxPathSumtaBmIN(matrix));


    }
}
