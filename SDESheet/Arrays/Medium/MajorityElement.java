/*
Given an array nums of size n, return the majority element.
        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

        Example 1:
        Input: nums = [3,2,3]
        Output: 3
        Example 2:

        Input: nums = [2,2,1,1,1,2,2]
        Output: 2
*/

package com.SDESheet.Arrays.Medium;

import java.util.HashMap;

public class MajorityElement {

    //To(ON)
    //So(On)
    //issue is we are taking extra space here by using hashmap
    private static int majorityElement_byHashing(int[] arr) {
        int n_by_2=arr.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int i: map.keySet()){
            if(map.get(i) > n_by_2){
                return i;
            }
        }
        return -1;
    }

    //Best Approach
   /*
    Approach :
    Approach:
    1.Initialize 2 variables:
        Count –  for tracking the count of element
        Element – for which element we are counting
    2.Traverse through the given array.
        If Count is 0 then store the current element of the array as Element.
        If the current element and Element are the same increase the Count by 1.
        If they are different decrease the Count by 1.
    3.The integer present in Element should be the result we are expecting
    */

    private static int majorityElement_byMooreVotingAlgo(int[] arr) {
       int count=0;
       //below value  is what might be the majority element
       int element=0;

       for(int i=0;i< arr.length;i++){
           if(count==0){
               element=arr[i];
               count=1;
           }
           else if(arr[i]==element){
               count++;
           }
           else{
               count--;
           }
       }

        //checking if the stored element
        // is the majority element:
        //Note : This last step / verification will not be done
        //if questions states you may assume that the majority element always exists in the array.
        int count_verification = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) count_verification++;
        }
        if (count_verification > (arr.length / 2)) return element;
        return -1;

    }


    public static void main(String[] args) {

      int arr[]={2,2,1,1,1,2,2};
      System.out.println(majorityElement_byHashing(arr));
      System.out.println(majorityElement_byMooreVotingAlgo(arr));


    }


}
