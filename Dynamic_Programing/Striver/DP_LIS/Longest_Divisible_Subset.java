package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Longest_Divisible_Subset {

    public  static List<Integer> PrintLITabulation(int[] nums, int n) {
        int[] dp = new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp,1);

        // Sort the array
        Arrays.sort(nums);

        int max=-1;
        int lastIndex=-1;
        for(int current=0;current<n;current++){
            hash[current]=current;
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[current] % nums[prev_index]  == 0 && 1 + dp[prev_index] > dp[current]){
                    dp[current] = 1 + dp[prev_index];
                    hash[current] = prev_index;
                }
            }
            if(dp[current]> max){
                max = dp[current];
                lastIndex = current;
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        return temp;

    }


    public static void main(String[] args) {

    }



}
