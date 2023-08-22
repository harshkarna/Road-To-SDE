package com.Dynamic_Programing.Striver.OneDimensionDP;

import java.util.Arrays;

public class MaxNonAdjacentSum {


    static int MaxNonAdjacentSumRec(int ind, int[] arr){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        int pick= arr[ind]+ MaxNonAdjacentSumRec(ind-2, arr);
        int nonPick = 0 + MaxNonAdjacentSumRec(ind-1, arr);

        return Math.max(pick, nonPick);
    }

    static int solve1(int n,int[] arr){
        return MaxNonAdjacentSumRec(n-1, arr);
    }




    static int MaxNonAdjacentSumMemo(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ MaxNonAdjacentSumMemo(ind-2, arr,dp);
        int nonPick = 0 + MaxNonAdjacentSumMemo(ind-1, arr, dp);

        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve2(int n,int[] arr){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return MaxNonAdjacentSumMemo(n-1, arr, dp);
    }


    static int MaxNonAdjacentSumTab(int n, int[] arr, int[] dp){
        //base casre
        dp[0]= arr[0];
        for(int i=1 ;i<n; i++){
            int pick = arr[i];
            if(i>1)
                pick += dp[i-2];
            int nonPick = 0 + dp[i-1];

            dp[i]= Math.max(pick, nonPick);
        }

        return dp[n-1];
    }

    static int solve3(int n, int[] arr){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return MaxNonAdjacentSumTab(n, arr, dp);
    }


    static int MaxNonAdjacentSumSpaceOptimise(int n, int[] arr) {

        int prev = arr[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int nonPick = 0 + prev;

            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;

        }
        return prev;
    }

    public static void main(String[] args) {

        int[] nums= {1,2,3,1};
        System.out.println(solve2(4,nums));


    }
}
