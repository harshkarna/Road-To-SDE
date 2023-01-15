/*Given a binary array nums, return the maximum number of consecutive 1's in the array.



        Example 1:

        Input: nums = [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.*/
package com.SDESheet.Arrays;

public class Max_ConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i <nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                if(count > max){
                    max=count;
                }
                count=0;
            }
            if(count > max){
                max=count;
            }
        }
        return  max;

    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }
}
