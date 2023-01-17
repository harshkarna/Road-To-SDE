/*Given an array of integers Arr of size N and a number K.
Return the maximum sum of a subarray of size K.

        Example 1:

        Input:
        N = 4, K = 2
        Arr = [100, 200, 300, 400]
        Output:
        700
        Explanation:
        Arr3  + Arr4 =700,
        which is maximum.

 */

package com.SlidingWindow;

public class MaximumSubarrayOfSizeK {

    private static int getMaxSubArray(int[] arr, int k) {
     int i=0;
     int j=0;
     int sum=0;
     int max=Integer.MIN_VALUE;
     //so running loop till window is within array limits
     while(j <=arr.length-1){
         //at every step adding j
         sum=sum+arr[j];
         //now if size of current window is lesser tha k , keep increasing its size until it matches k
         if(j-i+1 < k){
             j++;
         }
         //once window size matches k, check whether sum accumulated till now for that window if it
         //is greater than max , the replace max and also we need delete previous starting i of window from sum
         //so that we can move window and add j in next iteration.
         else if(j-i+1 ==k){
             max=Math.max(max,sum);
             sum=sum-arr[i];
             i++;
             j++;
         }
     }
     return max;

    }

    public static void main(String[] args) {
//       int[] arr={2,5,1,8,2,9,1};
        int[] arr={100,200,300,400};

        System.out.println(getMaxSubArray(arr,2));

    }


}
