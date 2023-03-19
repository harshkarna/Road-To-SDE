//Union of two arrays can be defined as the common and distinct elements in the two arrays.
//        Given two sorted arrays of size n and m respectively, find their union.
//
//
//        Example 1:
//
//        Input:
//        n = 5, arr1[] = {1, 2, 3, 4, 5}
//        m = 3, arr2 [] = {1, 2, 3}
//        Output: 1 2 3 4 5
//        Explanation: Distinct elements including
//        both the arrays are: 1 2 3 4 5.
package com.SDESheet.Arrays.Easy;

import java.util.ArrayList;
import java.util.TreeSet;

public class Union_of_two_sorted_arrays {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[])
    {
        TreeSet<Integer> set = new TreeSet<>();

        // Remove the duplicates from arr1[]
        for (int i : arr1)
            set.add(i);

        // Remove duplicates from arr2[]
        for (int i : arr2)
            set.add(i);

        // Loading set to array list
        ArrayList<Integer> list
                = new ArrayList<>();
        for (int i : set)
            list. add(i);

        return list;

    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        System.out.println(findUnion(arr1,arr2));;

    }
}
