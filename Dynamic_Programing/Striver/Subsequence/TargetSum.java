package com.Dynamic_Programing.Striver.Subsequence;

import java.util.Arrays;

public class TargetSum {

    static int targetSumMemo(int ind, int target, int[] arr,int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = targetSumMemo(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = targetSumMemo(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= (notTaken + taken);

    }

    static int targetSumM(int n,int target,int[] arr){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases, if its odd
        if((totSum+target)%2==1) return 0;

        int s1 = (totSum+target)/2;

        int dp[][] = new int[n][s1+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return targetSumMemo(n-1,1,arr,dp);
    }


    public static void main(String[] args) {


    }
}
