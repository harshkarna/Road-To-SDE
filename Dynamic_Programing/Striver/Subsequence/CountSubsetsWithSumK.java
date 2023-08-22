package com.Dynamic_Programing.Striver.Subsequence;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    static int findWaysRecusrion(int ind, int target, int[] arr){
        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        int notTaken = findWaysRecusrion(ind-1,target,arr);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysRecusrion(ind-1,target-arr[ind],arr);

        return notTaken + taken;
    }

    static int findWaysRe(int[] num, int k){
        int n = num.length;
        return findWaysRecusrion(n-1,k,num);
    }


    static int findWaysMemo(int ind, int target, int[] arr,int[][] dp){
        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = findWaysMemo(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysMemo(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= notTaken + taken;
    }

    static int findWaysMem(int[] num, int k){
        int n = num.length;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return findWaysMemo(n-1,k,num,dp);
    }



    public static void main(String[] args) {
        int[] arr={0,0,1};
        System.out.println(findWaysMem(arr,1));

    }

}
