/*Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
Merge them in sorted order without using any extra space.
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
        Example 1:
        Input:
        n = 4, arr1[] = [1 3 5 7]
        m = 5, arr2[] = [0 2 6 8 9]
        Output:
        arr1[] = [0 1 2 3]
        arr2[] = [5 6 7 8 9]
        Explanation:
        After merging the two
        non-decreasing arrays, we get,
        0 1 2 3 5 6 7 8 9.
        */
package com.SDESheet.Arrays.Hard;

import java.util.Arrays;

public class Merge2SortedArrays_GFG {

    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        int left =n-1;
        int right=0;
        while( left >=0 && right < m){
            if(arr1[left] > arr2[right]){
                //swap arr1 and arr2
                long temp=arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            else{
                break;
            }
       }
        Arrays.sort(arr1);
        Arrays.sort(arr2);


    }


    public static void main(String[] args) {


    }
}
