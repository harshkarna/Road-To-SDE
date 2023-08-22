package com.Dynamic_Programing.Striver.Subsequence;

public class MinSubsetSumDifference {

    static int subsetSumToKTab(int n,int[] arr){
        int totSum=0;
        for(int i=0; i<n;i++){
            totSum+= arr[i];
        }

        int k = totSum;

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

        int mini = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totSum; s1++) {
            if (dp[n - 1][s1] == true) {
                int diff = Math.abs(s1 - (totSum - s1));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
}


    public static void main(String[] args) {
        int[]  arr={-36,36};
        System.out.println(subsetSumToKTab(2,arr));


    }
}
