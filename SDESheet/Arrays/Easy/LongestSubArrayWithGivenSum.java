/*Given an array containing N integers and an integer K., Your task is to find the
length of the longest Sub-Array with the sum of the elements equal to the given value K.
        Example 1:
        Input :
        A[] = {10, 5, 2, 7, 1, 9}
        K = 15
        Output : 4
        Explanation:
        The sub-array is {5, 2, 7, 1}.*/

package com.SDESheet.Arrays.Easy;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

   //To-(N*1)
   //So(N) as we are using hashmap for every prefix
    public static int LongestSubArrayWithGivenSum_PrefixSum(int[] arr, int k){

       //for storing prefix sum
        HashMap<Integer, Integer> map=new HashMap<>();
        int sum=0;
        int length=0;
        for(int i=0;i <arr.length;i++){
            sum=sum+arr[i];
            if(sum==k){
                length=Math.max(length,i+1);
            }
            if(map.containsKey(sum-k)){
                length=Math.max(length,i-map.get(sum-k));
            }
            //edge case --
            //handling zero and negative integers
            //whenever we are getting same sum we are not updating that in map
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

        }
        return length;
    }


    //NoOte if the array contains positives and zero then this is the most optimal approach
    //because sliding window will not work for negative integers
    //To(N), So(1)
    public static int LongestSubArrayWithGivenSum_SlidingWindow(int[] arr, int k){
        int left=0;
        int right=0;
        int sum=arr[0];
        int length=0;
        int n =arr.length;
        //run till right is in array limits
        while(right < n){
            //if sum is beyond k , keep trimming from left until sum < k
            while(left <=right && sum > k){
                sum=sum-arr[left];
                left++;
            }
            //now if sum == k , then check the length and set it
            if(sum==k){
                length=Math.max(length,right-left+1);
            }
            //if all normal , just keep moving right and add to the sum
            right++;
            if(right < n){
                sum=sum+arr[right];
            }
        }
        return length;
    }

    public static void main(String[] args) {
     int[] arr={10, 5, 2, 7, 1, 9};
     int[] arr1={1,2,1,3};
     int k=15;
     int k1=2;
     System.out.println(LongestSubArrayWithGivenSum_PrefixSum(arr,k));
//     System.out.println(LongestSubArrayWithGivenSum_SlidingWindow(arr1,k1));



    }
}
