package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.Arrays;

public class Longest_Bitonic_Sequence {


    public  static int  LongestBitonicSequence(int[] nums)
    {
        int n =nums.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);


        for(int current=0;current<n;current++){
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[prev_index]<nums[current] ){
                    dp[current]=Math.max(1+dp[prev_index], dp[current]);
                }
            }
        }

        for(int current=n-1;current>=0;current--){
            for(int prev_index=n-1;prev_index>current;prev_index--){
                if(nums[prev_index]<nums[current] ){
                    dp2[current]=Math.max(1+dp2[prev_index], dp2[current]);
                }
            }
        }

        int maxi = -1;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[i] + dp2[i] - 1);
        }

        return maxi;

    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 3, 2};
        System.out.println(LongestBitonicSequence(nums));

    }
}
