/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

        Example 1:
        Input: nums = [3,2,3]
        Output: [3]
*/

package com.SDESheet.Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class MajorityElement2 {

    /*Solution 1: Brute-Force

    Approach: Simply count the no. of appearance for each element using nested loops and whenever you
    find the count of an element greater than N/3 times, that element will be your answer.

*/
    public static ArrayList< Integer > majorityElement(int arr[], int n) {
        ArrayList < Integer > ans = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i])
                    cnt++;
            }
            if (cnt > (n / 3))
                ans.add(arr[i]);
        }

        return ans;
    }

     /* Better
    To(ON)
    So(On)
    issue is we are taking extra space here by using hashmap
    Approach :
    1.Create a freq array
    2.Then iterate over map and return the key which has value over n/2

    */
     public static ArrayList <Integer > majorityElement_better(int arr[], int n) {
         HashMap < Integer, Integer > mp = new HashMap < > ();
         ArrayList < Integer > ans = new ArrayList < > ();
         for (int i = 0; i < n; i++) {
             mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
         }
         for (int x: mp.keySet()) {
             if (mp.get(x) > (n / 3))
                 ans.add(x);
         }
         return ans;
     }

     public static ArrayList < Integer > majorityElement(int[] nums) {
        int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            ans.add(number1);
        if (count2 > len / 3)
            ans.add(number2);
        return ans;
    }


    public static void main(String[] args) {
       int[] nums={3,2,3};


    }
}
