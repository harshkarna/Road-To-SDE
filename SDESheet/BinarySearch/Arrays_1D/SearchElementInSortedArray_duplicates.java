/*Given a sorted and rotated array A of N elements which is rotated at some point, and may contain duplicates and
given an element key. Check whether the key exist in the array A or not.

        Example 1:

        Input:
        N = 7
        A[] = {2,5,6,0,0,1,2}
        key = 0
        Output:
        1
        Explanation:
        0 is found at index 3.*/

package com.SDESheet.BinarySearch.Arrays_1D;

public class SearchElementInSortedArray_duplicates {

    static boolean search(int arr[], int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) /2 ;
            if (arr[mid] == target)
                return true;

            //now as now we have duplicates and there can be a situation where
            //low , mid , high are same and then  we will not be able to figure out
            //which side is sorted , for that we need trim the searching space
            //until we found the sorted part

            if(arr[low] == arr[mid] &&  arr[mid] == arr[high]){
                low=low+1;
                high=high-1;
                continue;
                //keep looping this until you find searching space
            }

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
        return false;
    }

    public static void main(String[] args) {


    }
}
