package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int LIS_R(int[] nums,int index, int prev_index){
        //base case
        if (index == nums.length) {
            return 0;
        }

        int notTake =0 +LIS_R(nums,index+1, prev_index);

        int take=0;
        if(prev_index==-1 || nums[index] > nums[prev_index]){
            take= 1 + LIS_R(nums,index+1, index);
        }
        return Math.max(take, notTake);

    }

    public  static int  lengthOfLISRecursion(int[] nums) {
        return LIS_R(nums,0,-1);

    }

    public static int LIS_M(int[] nums,int index, int prev_index, int[][] dp){
        //base case
        if (index == nums.length) {
            return 0;
        }
        if(dp[index][prev_index+1]!=-1) return dp[index][prev_index+1];


        int notTake =0 +LIS_M(nums,index+1, prev_index, dp);

        int take=0;
        if(prev_index==-1 || nums[index] > nums[prev_index]){
            take= 1 + LIS_M(nums,index+1, index, dp);
        }
        return dp[index][prev_index+1]=Math.max(take, notTake);

    }

    public  static int  lengthOfLISMemo(int[] nums) {
        int n = nums.length;;
        int[][] dp=new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return LIS_M(nums,0,-1, dp);

    }


    public  static int  lengthOfLITabulation(int[] nums) {
        int n = nums.length;;
        int[][] dp=new int[n+1][n+1];

        // base case we can ignore as dp already 0

        //store second state of dp by plus 1 everywhere here

        for(int index=n-1; index>=0; index--){
            for(int prev_index=index-1; prev_index>=-1; prev_index--){

                int notTake =0 + dp[index+1][prev_index+1];

                int take=0;
                if(prev_index==-1 || nums[index] > nums[prev_index]){
                    take= 1 + dp[index+1][index+1];
                }
                dp[index][prev_index+1]= Math.max(take, notTake);
            }
        }

        return dp[0][-1+1];

    }




    public static void main(String[] args) {

        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISRecursion(nums));
        System.out.println(lengthOfLISMemo(nums));
        System.out.println(lengthOfLITabulation(nums));




    }
}
