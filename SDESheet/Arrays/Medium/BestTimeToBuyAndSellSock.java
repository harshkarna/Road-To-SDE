/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a
        different day in the future to sell that stock.
        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
        Example 1:

        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        */
package com.SDESheet.Arrays.Medium;

public class BestTimeToBuyAndSellSock {

    /*Approach 1 :
    TO(N2)
    SO(1)
    BruteForce : Take one i , iterate through the next elements , and do minus with greater elements  and
    store sum in maxProfit , it will need two loops , and at last return max Profit.


    Approach 2 :
    TO(N)
    SO(1)
    2 pointer Approach
     1. Take one buying pointer and selling pointer starting from 1th index .
     2. do minus(sell - buy) and store the profit
     3. Now if profit is negative , make buy pointer to sell, as sell will be minimum till now that's why its profit came
        negative , and also make profit zero as we will discard negative profit
     4.if profit is positive , just check if its greater than max profit , replace it
     5. RePEAT this process until you find your profit.
    */
    private static int getBestTimeToBuyAndSellSock(int[] arr) {
        int buying_index =  0;
        int profit=0;
        int max_profit=0;

        for(int selling_index=1;selling_index <arr.length;selling_index++){
            profit=arr[selling_index]-arr[buying_index];
            if(profit <= 0 ){
                buying_index=selling_index;
                profit=0;
            }
            max_profit=Math.max(profit,max_profit);
        }
        return max_profit;
    }


    public static void main(String[] args) {
       int[] arr={2,1,4};
        System.out.println(getBestTimeToBuyAndSellSock(arr));

    }


}
