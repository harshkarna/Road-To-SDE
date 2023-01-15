/*
Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.

        Example 1:

        Input: nums = [3,0,1]
        Output: 2
        Explanation: n = 3 since there are 3 numbers, so all numbers
        are in the range [0,3]. 2 is the missing number in the range since
        it does not appear in num
*/

package com.SDESheet.Arrays;

public class FindMissingNumber {

    public int missingNumber(int[] nums) {
        /*
        There are many ways to solve this question, like
        one is XOR , one is by hashing and one is by taking sum of n
         naturatutal numbersthen minus by arrays sum , whatever left is missng number

        */
        int sum=0;
        for(int i:nums){
            sum=sum+i;
        }

        int sumNRange= (nums.length * (nums.length+1) )/2;

        return sumNRange-sum;
        /*

        Below is hash approach

        HashSet<Integer> set=new HashSet<>();
        int size=nums.length;
        for(int i=0;i<=size;i++){
            set.add(i);
        }

        HashSet<Integer> set2=new HashSet<>();
        for(int i : nums){
            set2.add(i);
        }

        for(int i : set){
            if(!set2.contains(i)){
                return i;
            }
        }
        return -1;

        */

    }
}
