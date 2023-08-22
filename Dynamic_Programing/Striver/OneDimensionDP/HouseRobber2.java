package com.Dynamic_Programing.Striver.OneDimensionDP;

import java.util.Arrays;

public class HouseRobber2 {

    /*here as first house and last is connected so in our answer we cant include both houses
    , so let's calculate first by excluding first and taking all , and then excluding last and taking all ,
    and out of both return the maximum

    and the whole logic will remain same as house robber 1
    * */

    static int MaxNonAdjacentSumMemo(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ MaxNonAdjacentSumMemo(ind-2, arr,dp);
        int nonPick = 0 + MaxNonAdjacentSumMemo(ind-1, arr, dp);

        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve(int[] arr){
        int n =arr.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return MaxNonAdjacentSumMemo(n-1, arr, dp);
    }

    public int rob(int[] nums) {
        int n =nums.length;
        int arr1[]=new int[n-1];
        int arr2[]=new int[n-1];

        if(n==1)
            return nums[0];

        //excluding last
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i];
        }
        //excluding first
        for (int i = 1; i < n; i++) {
            arr2[i - 1] = nums[i];
        }

        int ans1 = solve(arr1);
        int ans2 = solve(arr2);

        return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {


    }
}
