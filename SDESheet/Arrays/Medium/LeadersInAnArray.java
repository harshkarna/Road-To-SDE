/*
    Given an array A of positive integers. Your task is to find the leaders in the array.
    An element of array is leader if it is greater than or equal to all the elements
    to its right side. The rightmost element is always a leader.

        Example 1:
        Input:
        n = 6
        A[] = {16,17,4,3,5,2}
        Output: 17 5 2
        Explanation: The first leader is 17
        as it is greater than all the elements
        to its right.  Similarly, the next
        leader is 5. The right most element
        is always a leader so it is also
        included.
*/

package com.SDESheet.Arrays.Medium;

public class LeadersInAnArray {

     /*Approach 1 : Brute Force
        near by T0(N2)
        1.Collect all the leaders .
        2.Take an i , and check to its rightmost  end , if every elemnt
        is smaller than i , then i is a leader
        3.Like that collect all the leaders in a array format ,
        and you can return the array answer in desired format.
        * */

    /*Approach 2 :

     * */

    private static void getLeadersInAnArray(int[] arr) {
            int n =arr.length;
            //Choosing the right most element as the maximum
            int max = arr[n - 1];
            System.out.print(arr[n - 1] + " ");
            for (int i = n - 2; i >= 0; i--)
                if (arr[i] > max) {
                    //means we found the leader
                    System.out.print(arr[i] + " ");
                    //replace max with current leader
                    max = arr[i];
                }

            System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={16,17,4,3,5,2};
        getLeadersInAnArray(arr);
    }
}
