package com.Dynamic_Programing.Striver.DP_LIS;

import java.util.ArrayList;
import java.util.Arrays;

public class Print_LIS {

    public  static int  lengthOfLITabulation(int[] nums, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int max=-1;
        for(int current=0;current<n;current++){
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[prev_index]<nums[current] ){
                    dp[current]=Math.max(1+dp[prev_index], dp[current]);
                }
            }
            max=Math.max(max,dp[current]);
        }
        return max;
    }

    public  static int  PrintLITabulation(int[] nums, int n) {
        int[] dp = new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp,1);

        int max=-1;
        int lastIndex=-1;
        for(int current=0;current<n;current++){
            hash[current]=current;
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[prev_index]<nums[current] && 1 + dp[prev_index] > dp[current]){
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
        // reverse the array

        System.out.print("The subsequence elements are ");

        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
        System.out.println();

        return 1;

    }

    public  static int  PrintLITabulation_test(int[] nums, int n) {
        int[] dp = new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp,1);

        int max=-1;
        int lastIndex=-1;
        for(int current=1;current<n;current++){
            hash[current]=current;
            for(int prev_index=0;prev_index<current;prev_index++){
                if(nums[prev_index]<nums[current] && 1 + dp[prev_index] > dp[current]){
                    dp[current] = 1 + dp[prev_index];
                    hash[current] = prev_index;
                }
            }
            if(dp[current]> max){
                max = dp[current];
                lastIndex = current;
            }
        }

        // Printing the dp array
        System.out.println("DP Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println(); // Move to the next line after printing the array

        // Printing the hash array
        System.out.println("Hash Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(hash[i] + " ");
        }
        System.out.println(); // Move to the next line after printing the array

        return max; // Assuming you want to return the 'max' value or some other relevant value


    }



    public static void main(String[] args) {
        int arr[] = {1,3,5,4,7};

        int n = arr.length;

//        System.out.println("The length of the longest increasing subsequence is "+lengthOfLITabulation(arr,n));
        System.out.println("The longest increasing subsequence is "+PrintLITabulation_test(arr,n));


    }
}
