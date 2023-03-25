/*
Given an integer array nums, find the
        subarray
        with the largest sum, and return its sum.

        Example 1:

        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/

package com.SDESheet.Arrays.Medium;

public class MaximumSubArraySum {

    /*
    * Approach 1 : brute Force
    * Try out all subarrays
    * ToO(n2)
    *
    */


    //Best Approach
   /* Kadane's Algorithm TO(N)
    Approach:
    1. We will have the following variables in the beginning :
    2.msf – max so far, meh – max sum ending at ith index, start – to get the starting index
    of ans’s subarray, end – to get the ending index of ans’s subarray.
    3. Traverse the array from starting and add the ith element to max_end_here(meh),
    now we will check that adding the ith element gives a greater value than max_so_far(msf)
    or not, if yes then we will update our msf and also update the starting and
    ending index(initially starting index is zero).
*/
    private static int getMaxSubarraySum(int[] arr) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i <arr.length;i++){
            //just keep adding next elements to sum
            sum+=arr[i];
            //if sum become more than max , replace it
            if(sum> maxSum){
                maxSum=sum;
            }
            //if anytime sum drops below zero , make sum 0 and continue
            //here we are not dropping negative elements
            //we are making sum 0 when a neg number is making our sum below 0
            //as no need to take that value , it will hamper our max sum only
            if(sum< 0){
                sum=0;
            }
        }
        return maxSum;

    }
      /*
      * Same algo but if someone asks you ki also print the subarray with maximum sum,
      * so we need to add few things
      * */

    private static void printMaxSubarrayWithMaxSum(int[] arr) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int start=0;
        int startingIndex=-1;
        int endingIndex=-1;

        for(int i=0;i <arr.length;i++){
            if(sum==0){
                //here new subarray will be starting so we are storing starting index
                start=i;
            }
            //just keep adding next elements to sum
            sum+=arr[i];
            //if sum become more than max , replace it
            if(sum> maxSum){
                maxSum=sum;
                //here it means a subarray is completing
                //so we are storing endpoints
                startingIndex=start;
                endingIndex=i;
            }
            //if anytime sum drops below zero , make sum 0 and continue
            //here we are not dropping negative elements
            //we are making sum 0 when a neg number is making our sum below 0
            //as no need to take that value , it will hamper our max sum only
            if(sum< 0){
                sum=0;
            }
        }

        for(int i=startingIndex;i <=endingIndex;i++){
            System.out.print(arr[i]+ " ");
        }

    }

    public static void main(String[] args) {

        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSubarraySum(arr));
        printMaxSubarrayWithMaxSum(arr);

    }

}
