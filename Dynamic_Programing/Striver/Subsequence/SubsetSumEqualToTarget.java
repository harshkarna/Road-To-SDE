package com.Dynamic_Programing.Striver.Subsequence;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

    static boolean subsetSumToKRecu(int ind, int target,int[] arr){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        boolean notTaken = subsetSumToKRecu(ind-1,target,arr);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumToKRecu(ind-1,target-arr[ind],arr);
        return notTaken||taken;
    }

    static boolean subsetSumToKRec(int n, int k,int[] arr){

        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumToKRecu(n-1,k,arr);
    }

    static boolean subsetSumToKMemo(int ind, int target,int[] arr,int[][] dp){
        if(target==0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==1;

        boolean notTaken = subsetSumToKMemo(ind-1,target,arr,dp);

        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumToKMemo(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    static boolean subsetSumToKM(int n, int k,int[] arr){

        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return subsetSumToKMemo(n-1,k,arr,dp);
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
        // Print the dp array with indices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print("dp[" + i + "][" + j + "] = " + dp[i][j] + "    ");
            }
            System.out.println();
        }

        return dp[n-1][k];

    }

    static boolean subsetSumToKSpaceOptimised(int n, int k,int[] arr){


        boolean prev[]= new boolean[k+1];

        prev[0] = true;

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for(int ind = 1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target= 1; target<=k; target++){
                boolean notTaken = prev[target];

                boolean taken = false;
                if(arr[ind]<=target)
                    taken = prev[target-arr[ind]];

                cur[target]= notTaken||taken;
            }
            prev=cur;

        }

        return prev[k];
    }



    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int k=9;
        int n = arr.length;

        if(subsetSumToKTab(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
      }

}
