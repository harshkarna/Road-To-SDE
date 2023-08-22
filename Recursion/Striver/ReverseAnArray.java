package com.Recursion.Striver;

import java.util.Arrays;

public class ReverseAnArray {

    public static void reverseArray(int[] arr, int start, int end) {
        // Base case: Stop recursion when start >= end or array is empty
        if (start >= end || arr == null || arr.length == 0) {
            return;
        }

        // Swap the first and last elements
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursively reverse the remaining elements
        reverseArray(arr, start + 1, end - 1);
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Call the recursive function to reverse the array
        reverseArray(arr, 0, arr.length - 1);

        System.out.println("Reversed array: " + Arrays.toString(arr));
    }


}
