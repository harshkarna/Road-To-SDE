/*
0 1 Knapsack - Problem

        A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
        Input Format :
        The first line of the input contains an integer value N, which denotes the total number of items.

        The second line of input contains the N number of weights separated by a single space.

        The third line of input contains the N number of values separated by a single space.

        The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
        Output Format :
        Print the maximum value of V that the thief can steal.
        Constraints :
        1 <= N <= 20
        1<= Wi <= 100
        1 <= Vi <= 100

        Time Limit: 1 sec
        Sample Input 1 :
        4
        1 2 4 5
        5 4 8 6
        5
        Sample Output 1 :
        13
        Sample Input 2 :
        5
        12 7 11 8 9
        24 13 23 15 16
        26
        Sample Output 2 :
        51

*/

package com.Dynamic_Programing;

public class Knapsack {
    private static int getKnapsack(int[] weights, int[] values, int maxWeight, int i) {
        //base case
        if(maxWeight==0 || i==weights.length){
            return 0;
        }

        int myans;
        if(weights[i] <=maxWeight){
            int ans1=values[i]+ getKnapsack(weights, values, maxWeight -weights[i], i+1);//include i
            int ans2=getKnapsack(weights, values, maxWeight, i+1); //exclude i
            myans=Math.max(ans1,ans2);
        }
        else{
            myans=getKnapsack(weights, values, maxWeight, i+1);
        }
        return myans;
    }


    private static  int knapsackIterative(int[] weights, int[] values,int maxWeight){
        int n = values.length;
        int[][] dp=new int[n+1][maxWeight+1];

        for(int i=n-1;i>=0;i--){
            for(int w=0;w<=maxWeight;w++){
                int ans;
                if(weights[i] <= w){
                    int ans1=values[i] +dp[i+1][w-weights[i]];
                    int ans2=dp[i+1][w];
                    ans=Math.max(ans1,ans2);
                }
                else{
                    ans=dp[i+1][w];
                }

                dp[i][w]=ans;
            }
        }

        return dp[0][maxWeight];

    }



    public static void main(String[] args) {

        int n=4;
        int[] weights={1,2,4,5};
        int[] values={5,4,8,6};
        int maxWeight=5;

        System.out.println(getKnapsack(weights,values,maxWeight,0));
        System.out.println(knapsackIterative(weights,values,maxWeight));


    }


}