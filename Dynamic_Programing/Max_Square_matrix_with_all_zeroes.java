/*

Maximum Square Matrix With All Zeros

        Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square
        sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.
        Input format :
        The first line of the test case contains two integer values, 'N' and 'M', separated by
        a single space. They represent the 'rows' and 'columns' respectively.

        Second-line onwards, the next 'N' lines or rows represent the ith row values.

        Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
        Output Format:
        Print the size of maximum square sub-matrix.
        Constraints :
        0 <= N <= 10^4
        0 <= M <= 10^4

        Time Limit: 1 sec
        Sample Input 1:
        3 3
        1 1 0
        1 1 1
        1 1 1
        Sample Output 1:
        1
        Sample Input 2:
        4 4
        0 0 0 0
        0 0 0 0
        0 0 0 0
        0 0 0 0
        Sample Output 2:
        4
*/


package com.Dynamic_Programing;

public class Max_Square_matrix_with_all_zeroes {

    public  static int maximalSquare(int[][] matrix){
        int rows=matrix.length;
        int columns=matrix[0].length;

        int[][] dp=new int[rows+1][columns+1];
        int maxLength=Integer.MIN_VALUE;
        // for convenience, we add an extra all zero column and row
        // outside of the actual dp table, to simpify the transition
        for(int i=1;i <=rows;i++){
            for(int j=1;j <=columns;j++){
                if(matrix[i-1][j-1]== 0){
                    dp[i][j] = Math.min( dp[i - 1][j - 1],Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
      return maxLength * maxLength;

    }

    public static void main(String[] args) {
       int[][] matrix={{0,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1},{0,1,1,1,1},{0,0,1,1,1}};

        System.out.println(maximalSquare(matrix));

    }
}
