//Maximum Frequency Number
//
//        You are given an array of integers that contain numbers in random order. Write a program to find and return
//        the number which occurs the maximum times in the given input.
//        If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
//        Input Format:
//        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
//        The following line contains N space separated integers, that denote the value of the elements of the array.
//        Output Format :
//        The first and only line of output contains most frequent element in the given array.
//        Constraints:
//        0 <= N <= 10^8
//        Time Limit: 1 sec
//        Sample Input 1 :
//        13
//        2 12 2 11 12 2 1 2 2 11 12 2 6
//        Sample Output 1 :
//        2
//        Sample Input 2 :
//        3
//        1 4 5
//        Sample Output 2 :
//        1

package com.Hashmaps;

import java.util.HashMap;

public class Maximum_Frequency_Number {

    private static int getMaxFreq(int[] arr) {
        //creating a hashmap of integers
        HashMap<Integer,Integer>  map=new HashMap<>();
        for(int i :arr){
            //if key is already there , increase its count by 1
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            //else just simply put 1
            else{
                map.put(i,1);
            }
        }

        //now we need to iterate once more time to get whose key has max value
        int max = 0, ans = Integer.MIN_VALUE;
        for (int i : arr) {
            //getting the value of each key and comparing if its max
            if (map.get(i) > max) {
                max = map.get(i);
                ans = i;
            }
        }
        System.out.println(max);
        return ans;
    }

    public static void main(String[] args) {

        int arr[]={2 ,12 ,2 ,11 ,12 ,2, 1, 2, 2, 11 ,12 ,2, 6};
        int maxFreq=getMaxFreq(arr);
        System.out.println(maxFreq);

    }

}
