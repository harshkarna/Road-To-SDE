package com.Dynamic_Programing.Striver.DP_Stocks;


/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share
        of the stock at any time. However, you can buy it then immediately sell it on the same day.

        Find and return the maximum profit you can achieve.


        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.
*/

import java.util.Arrays;

public class BuySellStock_2 {


    public static int maxProfitR(int index, boolean buy, int[] prices) {
        //base case
        if(index== prices.length){
            return 0;
        }
        int profit=0;
        if (buy) {
            // If we're currently holding a stock, we have two choices:
            // 1. Sell the stock today and move to the next day with 'buy' set to false.
            // 2. Do nothing and move to the next day with 'buy' still set to true.
            profit = Math.max(-prices[index] + maxProfitR(index + 1, false, prices),
                    0 + maxProfitR(index + 1, true, prices));
        } else {
            // If we're not holding a stock, we have two choices:
            // 1. Buy a stock today and move to the next day with 'buy' set to true.
            // 2. Do nothing and move to the next day with 'buy' still set to false.
            profit = Math.max(prices[index] + maxProfitR(index + 1, true, prices),
                    0 + maxProfitR(index + 1, false, prices));
        }
        return profit;
    }

    public  static int  maxProfit(int[] prices) {
       int  maxProfit =maxProfitR(0,true,prices);
       return maxProfit;
    }

    public static int maxProfitM(int index, int buy, int[] prices, int[][] dp) {
        //base case
        if (index == prices.length) {
            return 0;
        }

        if( dp[index][buy] !=-1)
            return dp[index][buy];

        int profit = 0;
        if (buy == 1) {
            // If we're currently holding a stock, we have two choices:
            // 1. Sell the stock today and move to the next day with 'buy' set to false.
            // 2. Do nothing and move to the next day with 'buy' still set to true.
            profit = Math.max(-prices[index] + maxProfitM(index + 1, 0, prices,dp),
                    0 + maxProfitM(index + 1, 1, prices,dp));
        } else {
            // If we're not holding a stock, we have two choices:
            // 1. Buy a stock today and move to the next day with 'buy' set to true.
            // 2. Do nothing and move to the next day with 'buy' still set to false.
            profit = Math.max(prices[index] + maxProfitM(index + 1, 1, prices,dp),
                    0 + maxProfitM(index + 1, 0, prices,dp));
        }
        return  dp[index][buy] = profit;

    }

    public  static int  maxProfitMemo(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return maxProfitM(0,1,prices,dp);
    }

    public  static int  maxProfitTabulation(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];

        //base case
        dp[n][0]=0;
        dp[n][1]=0;

        for(int index=n-1; index >=0;index--){
            for(int buy=1;buy>=0;buy--){
                int profit = 0;
                if (buy == 1) {
                    // If we're currently holding a stock, we have two choices:
                    // 1. Sell the stock today and move to the next day with 'buy' set to false.
                    // 2. Do nothing and move to the next day with 'buy' still set to true.
                    profit = Math.max(-prices[index] + dp[index + 1][0],
                            0 + dp[index + 1][1]);
                } else {
                    // If we're not holding a stock, we have two choices:
                    // 1. Buy a stock today and move to the next day with 'buy' set to true.
                    // 2. Do nothing and move to the next day with 'buy' still set to false.
                    profit = Math.max(prices[index] + dp[index + 1][ 1],
                            0 +  dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    static long getMaximumProfitSpaceOptimised(long[] Arr, int n) {
        // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        long[] ahead = new long[2];
        long[] cur = new long[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
           ahead=cur;
        }
        return ahead[1]; // The maximum profit is stored in 'cur[0]'
    }


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitMemo(prices));
        System.out.println(maxProfitTabulation(prices));



    }
}
