/*Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element key. The task is to find the index of the given element key in the array A. The whole array A is given as the range to search.

        Example 1:

        Input:
        N = 9
        A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
        key = 10
        l = 0 , h = 8
        Output:
        5
        Explanation: 10 is found at index 5.*/

package com.SDESheet.BinarySearch.Arrays_1D;

public class SearchElementInSortedArray {

    static int search(int arr[], int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) /2 ;
            if (arr[mid] == target)
                return mid;

            // first check which side is sorted and will perform our check only on that side

            // if left is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && arr[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else
            // if right is sorted
            {
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {


    }
}
