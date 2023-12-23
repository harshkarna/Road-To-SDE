package com.Dynamic_Programing.Striver.DP_Stocks;

/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

        After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



        Example 1:

        Input: prices = [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]
        Example 2:

        Input: prices = [1]
        Output: 0*/

import java.util.Arrays;

public class BuySellStock_5 {

    public static int maxProfitR(int index, boolean buy, int[] prices) {
        //base case
        if(index >= prices.length){
            return 0;
        }
        int profit=0;
        if (buy) {
            profit = Math.max(-prices[index] + maxProfitR(index + 1, false, prices),
                    0 + maxProfitR(index + 1, true, prices));
        } else {
            //here if you are selling the stock before you buy again you need to wait 1 day , so index+2
            profit = Math.max(prices[index] + maxProfitR(index + 2, true, prices),
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
        if (index >= prices.length) {
            return 0;
        }

        if( dp[index][buy] !=-1)
            return dp[index][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] + maxProfitM(index + 1, 0, prices,dp),
                    0 + maxProfitM(index + 1, 1, prices,dp));
        } else {
            profit = Math.max(prices[index] + maxProfitM(index + 2, 1, prices,dp),
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

        //base case , doesnt matter as dp is already declared zero
        dp[n][0]=0;
        dp[n][1]=0;

        for(int index=n-1; index >=0;index--){
            for(int buy=1;buy>=0;buy--){
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(-prices[index] + dp[index + 1][0],
                            0 + dp[index + 1][1]);
                } else {
                    profit = Math.max(prices[index] + dp[index + 2][ 1],
                            0 +  dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }


    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitMemo(prices));
        System.out.println(maxProfitTabulation(prices));


    }
}
