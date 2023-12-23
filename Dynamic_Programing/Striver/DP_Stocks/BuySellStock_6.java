package com.Dynamic_Programing.Striver.DP_Stocks;

/*You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

        Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

        Note:

        You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
        The transaction fee is only charged once for each stock purchase and sale.


        Example 1:

        Input: prices = [1,3,2,8,4,9], fee = 2
        Output: 8
        Explanation: The maximum profit can be achieved by:
        - Buying at prices[0] = 1
        - Selling at prices[3] = 8
        - Buying at prices[4] = 4
        - Selling at prices[5] = 9
        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
        Example 2:

        Input: prices = [1,3,7,5,10,3], fee = 3
        Output: 6*/

public class BuySellStock_6 {

    public static int maxProfitTabulation(int[] prices, int fee) {

        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        //base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit = 0;
                if (buy == 1) {

                    profit = Math.max(-prices[index] + dp[index + 1][0],
                            0 + dp[index + 1][1]);
                } else {
                    //whenever you are selling then can also subtract transaction fee from the profit or you
                    //can also pay upfront when you buy
                    profit = Math.max(prices[index] - fee + dp[index + 1][1],
                            0 + dp[index + 1][0]);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }


    





    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        System.out.println(maxProfitTabulation(prices,2));

    }
}
