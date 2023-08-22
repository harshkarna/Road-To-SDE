package com.Dynamic_Programing.Striver.Subsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    static boolean subsetSumUtilMemo(int ind, int target,int arr[],int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==1;

        boolean notTaken = subsetSumUtilMemo(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumUtilMemo(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    static boolean canPartition(int n,int[] arr){
        int totSum=0;
        for(int i=0; i<n;i++){
            totSum+= arr[i];
        }
        if (totSum%2==1) return false;
        else{
            int k = totSum/2;
            int dp[][]=new int[n][k+1];
            for(int row[]: dp)
                Arrays.fill(row,-1);
            return subsetSumUtilMemo(n-1,k,arr,dp);
        }
    }

    static boolean subsetSumToKTab(int n, int k,int[] arr){

        boolean dp[][]= new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            for(int target= 1; target<=k; target++){

                boolean notTaken = dp[ind-1][target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken||taken;
            }
        }
        return dp[n-1][k];

    }
    static boolean canPartitionT(int n,int[] arr){
        int totSum=0;
        for(int i=0; i<n;i++){
            totSum+= arr[i];
        }
        if (totSum%2==1) return false;
        else{
            int k = totSum/2;
            return subsetSumToKTab(n-1,k,arr);
        }
    }




    public static void main(String[] args) {


    }
}
