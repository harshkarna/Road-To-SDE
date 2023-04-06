/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

        For example, for arr = [1,2,3], the following are all the permutations of arr:
        [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
        The next permutation of an array of integers is the next lexicographically greater
        permutation of its integer. More formally, if all the permutations of the array are sorted in
         one container according to their lexicographical order, then the next permutation of that array
         is the permutation that follows it in the sorted container. If such arrangement is not possible,
         the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

        For example, the next permutation of arr = [1,2,3] is [1,3,2].
        Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
        While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
        lexicographical larger rearrangement.
        Given an array of integers nums, find the next permutation of nums.

        The replacement must be in place and use only constant extra memory.

*/

package com.SDESheet.Arrays.Medium;

public class NextPermuation {

    /*Approach 1 : Brute Force
    1.Generate all the possible permutations of array  and store in sorted order
    2. Do a linear search to find that value
    3.After finding return its next value .
    * */

    /*
    Approach 2: Follow the patterns
    Note : See GFG pic to understand better -- https://www.geeksforgeeks.org/next-permutation/
    * Follow the steps below to implement the above observation:
    1.Iterate over the given array from end and find the first index (pivot) which doesn’t follow
    property of non-increasing suffix, (i.e,  arr[i] < arr[i + 1]).
    2.Check if pivot index does not exist
    This means that the given sequence in the array is the largest as possible. So, swap the complete array.
    3.Otherwise, Iterate the array from the end and find for the successor of pivot in suffix.
    4.Swap the pivot and successor
    5.Minimize the suffix part by reversing the array from pivot + 1 till N.
* */


    private static void getNextPermuation(int[] arr) {
        int n = arr.length, i, j;
        // Find for the pivot element./ break point
        // A pivot is the first element from
        // end of sequence which doesn't follow
        // property of non-increasing suffix
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        // Check if pivot is not found means its the largest possible permutation
        //then just return the reverse means lowest possible array
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
        }

        // if pivot is found
        else {
            // Find for the successor (means just next of pivot) of pivot in suffix
            for (j = n - 1; j > i; j--) {
                if (arr[j] > arr[i]) {
                    break;
                }
            }

            // Swap the pivot and successor
            swap(arr, i, j);

            // Minimise the suffix part
            reverse(arr, i + 1, arr.length - 1);
        }
    }

    static void reverse(int[] arr, int start, int end)
    {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
      int[] arr={1,3,2};
      getNextPermuation(arr);

    }


}
