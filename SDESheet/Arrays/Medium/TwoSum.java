/*Given an array of integers nums and an integer target, return indices of the two numbers such
 that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.
        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

package com.SDESheet.Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
   //Brute force
    //Take
    public  static int[] twoSum_Loops(int[] nums, int target) {
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if( (nums[i] + nums[j] ) == target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }


/*  By hashing
    Using Prefix Sum method
    First lets put values with their indexes in map
    /x+y =sum , then we will find in map if sum -y exists in map if yes just return the indexes
    */
    public  static int[] twoSum_hashing(int[] nums, int target) {
        int arr[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i < nums.length;i++){
            //if map contains sum-x , means we got our answer
            if(map.containsKey(target-nums[i])){
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;
            }
            //if new value comes , just enter them with their values
            map.put(nums[i],i);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr={2,7,11,15};
        int target=9;
        int[] output=twoSum_hashing(arr,target);
        for(int i :output){
            System.out.println(i + " ");
        }


    }
}
