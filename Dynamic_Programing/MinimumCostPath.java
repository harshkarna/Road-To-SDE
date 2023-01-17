/*
Min Cost Path Problem

        An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
        From a cell (i, j), you can move in three directions:
        1. ((i + 1),  j) which is, "down"
        2. (i, (j + 1)) which is, "to the right"
        3. ((i+1), (j+1)) which is, "to the diagonal"
        The cost of a path is defined as the sum of each cell's values through which the route passes.
        Input format :
        The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

        The second line onwards, the next 'M' lines or rows represent the ith row values.

        Each of the ith row constitutes 'N' column values separated by a single space.
        Output format :
        Print the minimum cost to reach the destination.
        Constraints :
        1 <= M <= 10 ^ 2
        1 <= N <=  10 ^ 2

        Time Limit: 1 sec
        Sample Input 1 :
        3 4
        3 4 1 2
        2 1 8 9
        4 7 8 1
        Sample Output 1 :
        13
        Sample Input 2 :
        3 4
        10 6 9 0
        -23 8 9 90
        -200 0 89 200
        Sample Output 2 :
        76
        Sample Input 3 :
        5 6
        9 6 0 12 90 1
        2 7 8 5 78 6
        1 6 0 5 10 -4
        9 6 2 -10 7 4
        10 -2 0 5 5 7
        Sample Output 3 :
        18
*/

package com.Dynamic_Programing;

import com.sun.javafx.stage.StageHelper;

import java.util.Scanner;

public class MinimumCostPath {
    public static int[][] takeInput(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no.of Rows");
        int rows=sc.nextInt();
        System.out.println("Enter the no.of Cols");
        int cols=sc.nextInt();

        int[][] arr =new int[rows][cols];

        //Take input from array
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("Enter the element at "+i+" row "+j+" columns");
                arr[i][j]=sc.nextInt();

            }
        }
        return arr;
    }


/*    Recursion approach :
    The idea is here ki we will solve 1 case and rest recursion will handle
    so we will stand at suppose 0,0 and ask recursion to go in left , diag and down and bring all the cost
    from all 3 directions , then at induction step we need to return the value at which we are standing + min of all
     above 3 paths .

    */

    public static  int minCostPath(int[][] cost,int i , int j){

        int m=cost.length;
        int n=cost[0].length;

       /*Special Case:
        For when i is on m-1, n-1 (last index),  so all directions will be blocked , hence we need to return
        the value  accumulated at that time
        */
        if(i==m-1 && j==n-1){
            return cost[i][j];
        }

       /* Now Base case
        when ever the i, j either is crossing boundary of matrix , we need to set that direction infinity*/
        if( i >=m || j>=n){
            return Integer.MAX_VALUE;
        }

        int ans1Right=minCostPath(cost,i,j+1);
        int ans2Diag=minCostPath(cost,i+1,j+1);
        int ans3Down=minCostPath(cost,i+1,j);

        int finalAnswer=cost[i][j] +Math.min(ans1Right,Math.min(ans2Diag,ans3Down));
        return finalAnswer;

    }


    public static  int minCostPathIterative(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;

        //first lets fill the array with infinity
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i< dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        // now lets fill the array from second last to top and from right to left , going up.
        // will have m-1 and n-1 as base case
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                /*Special Case:
                 For when i is on m-1, n-1, so all directions will be blocked , hence we need to return
                  the value  accumulated at that time
                  */
                if(i==m-1 && j==n-1){
                    dp[i][j]=grid[i][j];
                    continue;
                }

                int ans1Right=dp[i][j+1];
                int ans2Diag=dp[i+1][j+1];
                int ans3Down=dp[i+1][j];

                dp[i][j]=grid[i][j] + Math.min(ans1Right,Math.min(ans2Diag,ans3Down));

            }
        }
        return dp[0][0];


    }

    public static  int minCostPathDPR(int[][] cost,int i , int j,int[][] dp){

        int m=cost.length;
        int n=cost[0].length;

       /*Special Case:
        For when i is on m-1, n-1, so all directions will be blocked , hence we need to return
        the value  accumulated at that time
        */
        if(i==m-1 && j==n-1){
            return cost[i][j];
        }
       /* Now Base case
        when ever the i, j either is crossing boundary of matrix , we need to set that direction infinity*/
        if( i >=m || j>=n){
            return Integer.MAX_VALUE;
        }

        int ans1Right,ans2Diag,ans3Down;
        if(dp[i][j+1]== Integer.MIN_VALUE){
            ans1Right=minCostPath(cost,i,j+1);
            dp[i][j+1]=ans1Right;
        }
        else{
            ans1Right=dp[i][j+1];
        }

        if(dp[i+1][j+1]== Integer.MIN_VALUE){
            ans2Diag=minCostPath(cost,i+1,j+1);
            dp[i+1][j+1]=ans2Diag;
        }
        else{
            ans2Diag=dp[i+1][j+1];
        }

        if(dp[i+1][j]== Integer.MIN_VALUE){
            ans3Down=minCostPath(cost,i+1,j);
            dp[i+1][j]=ans3Down;
        }
        else{
            ans3Down=dp[i+1][j];
        }

        int finalAnswer=cost[i][j] +Math.min(ans1Right,Math.min(ans2Diag,ans3Down));

        return finalAnswer;

    }



    public static void main(String[] args) {

//        int[][] input=takeInput();
        int[][] cost={{1,5,11},{8,13,12},{2,3,7},{15,16,18}};
        int[][] dp=new int[cost.length+1][cost[0].length+1];
        for(int i=0;i< dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        System.out.println(minCostPath(cost,0,0));
        System.out.println(minCostPathDPR(cost,0,0,dp));
        System.out.println(minCostPathIterative(cost));



    }
}
