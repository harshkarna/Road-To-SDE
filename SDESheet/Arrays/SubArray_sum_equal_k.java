/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

        A subarray is a contiguous non-empty sequence of elements within an array.



        Example 1:

        Input: nums = [1,1,1], k = 2
        Output: 2
*/

package com.SDESheet.Arrays;

import java.util.HashMap;

public class SubArray_sum_equal_k {

    /*
Learning from this question :

        1.Sliding window approach - we cant use that here, because negative numbers
        2.2pointer also will not work
        3.we can use prefix sum

        */


 /*   --Bruteforce approach

    public  static int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        for(int i=0;i< nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum==k){
                    count++;
                }
            }

        }
        return count;
    }

    */
/*
    2nd approach using prefix sum and Hashmap
    what algo says :
    1.Initialise sum=0 and count=0;
    2.Traverse over array
        1.keep adding sum =sum+ arr[i]
        2.if(sum==k) count++;
        3.then if you get (sum-k) is present in hashmap , it means you got a subarray,
         do count =count+ frequency of value of that subarray present in the map ;
        4.last add that sum in hashmap
        5.continue to next arr[i] , and repeat the process till the array finishes

        Link - https://www.youtube.com/watch?v=XjP2mQr98WQ

            */
    public  static int subarraySum(int[] nums, int k) {
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            sum=sum+nums[i];
            if(sum==k){
                count++;
            }
            /*This is the most crucial step of this problem. Here we check if (prefix sum - k) is present in the map.
            If it is, then it implies that there are possible subarray. Now we add the frequency to the count because
            if there might be more than one regions in the given array where the subarray sum is equal to k.
            */
            if(map.containsKey(sum-k)){
               count=count+map.get(sum-k);
            }
            /* Finally, we put the sum element to the map.
            */
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }
        return count;
    }


    public static void main(String[] args) {
       int[] nums = {4,5,1,3,2,3,4};
       int  k = 9;
        System.out.println(subarraySum(nums,k));
    }
}
