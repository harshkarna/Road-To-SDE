package com.Dynamic_Programing.Striver.Subsequence;

import java.util.Arrays;

public class CountPartitionsWithDifference {

    static int mod =(int)1e9;
    static int countPartitionsMemo(int ind, int target,int[] arr, int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = countPartitionsMemo(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = countPartitionsMemo(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= (notTaken + taken)%mod;
    }

    static int countPartitions(int d,int[] arr){
        int n = arr.length;
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }

        //Checking for edge cases, if its odd
        if((totSum-d)%2==1) return 0;

        int s1 = (totSum+d)/2;

        int dp[][] = new int[n][s1+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return countPartitionsMemo(n-1,s1,arr,dp);
    }


    public static void main(String[] args) {

        int[] arr={1,1,1,1};
        System.out.println(countPartitions(0,arr));


    }
}
