//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]

package com.SDESheet.Arrays.Easy;

public class Rotate_array_by_k_places {

    public  void reverse (int[] nums, int i , int j){

        while (i < j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }


    public void rotate(int[] nums, int k) {
/*
        Now this is Brute Force , but while submitting gives TLE

        int temp;
        int n=nums.length;
        //this i will iterate for k times
        for(int i=0;i<k;i++){
            //storing last element in temp
            temp=nums[n-1];
            for(int j=n-2;j>=0;j--){
                //shifting each element to right
                nums[j+1]=nums[j];
            }
            //after 1 iteration is over add stored temp at first index
            nums[0]=temp;
        }

*/
        //  here is second approach , in array rotation problem we can use
        //  array reversal algorithm

        //there can be case if k is greater than length of array
        //then we just do mod of k and will do rotate by the remainder left
        //taking mod of k with length;
        k = k % nums.length;
        //firsts part before n-k
        reverse(nums,0,nums.length -k-1);
        //second part k
        reverse(nums,nums.length - k ,nums.length -1 );
        //third full array reverse
        reverse(nums,0,nums.length-1);

    }

}
