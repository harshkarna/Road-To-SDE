package com.Dynamic_Programing.Striver.DP_Stocks;

/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        Find the maximum profit you can achieve. You may complete at most two transactions.

        Note: You may not engage in multiple transactions simultaneously
        (i.e., you must sell the stock before you buy again).

        Example 1:

        Input: prices = [3,3,5,0,0,3,1,4]
        Output: 6
        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.*/

import java.util.Arrays;

public class BuySellStock_3 {
    public static int maxProfitR(int index, int buy, int cap,int[] prices) {
        //base case
        if(cap==0) return 0;
        if(index== prices.length){
            return 0;
        }
        int profit=0;
        if (buy==1) {
            // If we're currently holding a stock, we have two choices:
            // 1. Sell the stock today and move to the next day with 'buy' set to false.
            // 2. Do nothing and move to the next day with 'buy' still set to true.
            profit = Math.max(-prices[index] + maxProfitR(index + 1, 0,cap, prices),
                    0 + maxProfitR(index + 1, 1,cap, prices));
        } else {
            // If we're not holding a stock, we have two choices:
            // 1. Buy a stock today and move to the next day with 'buy' set to true.
            // 2. Do nothing and move to the next day with 'buy' still set to false.
            profit = Math.max(prices[index] + maxProfitR(index + 1, 1,cap-1, prices),
                    0 + maxProfitR(index + 1, 0, cap,prices));
        }
        return profit;
    }

    public static int maxProfitRec(int[] prices) {
        return maxProfitR(0,1,2,prices);
    }

    public static int maxProfitMemo(int index, int buy, int cap,int[] prices, int[][][] dp) {
        //base case
        if(cap==0) return 0;
        if(index== prices.length){
            return 0;
        }
        if( dp[index][buy][cap] !=-1) return dp[index][buy][cap];
        int profit=0;

        if (buy==1) {
            // If we're currently holding a stock, we have two choices:
            // 1. Sell the stock today and move to the next day with 'buy' set to false.
            // 2. Do nothing and move to the next day with 'buy' still set to true.
            profit = Math.max(-prices[index] + maxProfitR(index + 1, 0,cap, prices),
                    0 + maxProfitR(index + 1, 1,cap, prices));
        } else {
            // If we're not holding a stock, we have two choices:
            // 1. Buy a stock today and move to the next day with 'buy' set to true.
            // 2. Do nothing and move to the next day with 'buy' still set to false.
            profit = Math.max(prices[index] + maxProfitR(index + 1, 1,cap-1, prices),
                    0 + maxProfitR(index + 1, 0, cap,prices));
        }
        return dp[index][buy][cap]=profit;
    }

    public static int maxProfitM(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];

        // Initialize the dp array with -1 (3D Array )
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfitR(0,1,2,prices);
    }


    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp=new int[n+1][2][3];
        //base case
        // (But as we are declaring array as 0 so it didnt matter also if we dont write base cases here, as our bases are making again zero)
        //When cap is 0 , index and buy can be anything
        for(int index=0; index < n;index++){
            for(int buy=0; buy>=1;buy++){
                dp[index][buy][0]=0;
            }
        }
        //when index is n , buy and can be anything
        for(int buy=0; buy>=1; buy++){
            for(int cap=0;cap>=1; cap++){
                dp[n][buy][cap]=0;
            }
        }

        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){ //cap started from 1 because 0 is a base case which means no transaction allowed
                    int profit=0;
                    if (buy==1) {
                        // If we're currently holding a stock, we have two choices:
                        // 1. Sell the stock today and move to the next day with 'buy' set to false.
                        // 2. Do nothing and move to the next day with 'buy' still set to true.a
                        profit = Math.max(-prices[index] + dp[index + 1][0][cap],
                                0 + dp[index + 1][1][cap]);
                    } else {
                        // If we're not holding a stock, we have two choices:
                        // 1. Buy a stock today and move to the next day with 'buy' set to true.
                        // 2. Do nothing and move to the next day with 'buy' still set to false.
                        profit = Math.max(prices[index] + dp[index + 1][ 1][cap-1],
                                0 + dp[index + 1][0][cap]);
                    }
                    dp[index][buy][cap]=profit;
                }

            }

        }
        return dp[0][1][2];
    }

    static int maxProfitSpaceOptimised(int[] prices) {
        int n = prices.length;

        // Create a 2D array 'ahead' and 'cur' to store profit values
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        // Loop through the prices array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }

            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }

        // The maximum profit with 2 transactions is stored in ahead[0][2]
        return ahead[0][2];
    }


    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
//        System.out.println(maxProfitRec(prices));
//        System.out.println(maxProfitM(prices));
        System.out.println(maxProfitTabulation(prices));



    }
}
