/*
Given an array arr of N integers and an integer K, find the number of subsets of arr having XOR of elements as K.


        Example 1:

        Input:
        N = 4
        k = 6
        arr: 6 9 4 2
        Output:
        2
        Explanation:
        The subsets are
        {4,2} and {6}

*/

package com.SDESheet.Arrays.Hard;

import java.util.HashMap;

public class NumberOfSubArraysWithXOR_K {

    /*Brute Force
    Find all the possible subarrays
    The brute force solution is to generate all possible subarrays.
    For each generated subarray we get the respective XOR and then check if this XOR is equal to B. If it is then we increment the count. In the end, we will get the count of all possible subarrays that have XOR equal to B.


    *
    * */
    public static int solve(int[] A, int B) {
        int c=0;
        for(int i=0;i<A.length;i++){
            int current_xor = 0;
            for(int j=i;j<A.length;j++){
                current_xor^=A[j];
                if(current_xor==B) c++;
            }
        }
        return c;
    }


   public  static int subsetXOR(int arr[], int N, int K) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int xr = 0;
       int count= 0;
       map.put(0,1);
       for (int i = 0; i < arr.length; i++) {
           xr = xr ^ arr[i] ;
//           if (xr == K) count++;
           int x = xr ^ K;
           if (map.containsKey(x)) {
               count= count +map.get(x);
           }
           map.put(xr, map.getOrDefault(xr, 0) + 1);
       }
       return count;

    }


    public static void main(String[] args) {


    }
}
