package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.Arrays;

public class NumberOfLongestSubsequence {

    public  static int  No_ofLIS(int[] nums, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] count = new int[n];
        Arrays.fill(count,1);

        int max=-1;
        for(int current=1;current<n;current++){
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[prev_index]<nums[current] && 1+dp[prev_index] >dp[current]){
                    //inherit, first time occurring
                    dp[current]=1+dp[prev_index];
                    count[current]=count[prev_index];

                }
                else if(nums[prev_index]<nums[current] && 1+dp[prev_index] == dp[current]){
                    //occurring again, increase the count
                    count[current]=count[current]+count[prev_index];
                }
            }
            max=Math.max(max,dp[current]);
        }

        int no_of_lis=0;

        for(int i =0; i < dp.length ;i++){
            if(dp[i]==max){
                no_of_lis=no_of_lis+count[i];
            }
        }
        return no_of_lis;
    }


    public static void main(String[] args) {
        int arr[] = {1,3,5,4,7};

        int n = arr.length;

//        System.out.println("The length of the longest increasing subsequence is "+lengthOfLITabulation(arr,n));
        System.out.println("The longest increasing subsequence is "+No_ofLIS(arr,n));




    }
}
