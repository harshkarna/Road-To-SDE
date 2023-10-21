package com.Dynamic_Programing.Striver.OneDimensionDP;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n==1 || n==2 ){
            return n;
        }

        int left=climbStairs(n-1);
        int right=climbStairs(n-2);
        return left+right;
    }

    public int climbStairsMemo(int n) {
        //Approach : Memoization
        int[] dp=new int[n+1];
        for(int i=0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        return getCountMemoization(n,dp);
    }

    private int getCountMemoization(int n, int dp[]){
        if(n==1 || n==2 ){
            return n;
        }
        if(dp[n]!=-1)return dp[n];
        dp[n]=getCountMemoization(n-1,dp)+getCountMemoization(n-2,dp);
        return dp[n];
    }

    public int climbStairsTab(int n) {
        //Approach 2: Iterative
        if(n==1 || n==2 ){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }






    public static void main(String[] args) {


    }
}
