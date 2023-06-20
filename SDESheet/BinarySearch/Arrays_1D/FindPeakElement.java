package com.SDESheet.BinarySearch.Arrays_1D;

public class FindPeakElement {

    public int peakElement(int[] arr,int n)
    {
        /*Here , will do the binary search and we need to take  which side to eliminate
        */

        //handling edge cases , if suppose first or last is our peak , then no need to  perform algo
        if(n==1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        //as we already checked for 1st and last , we will start performing check from
        // 2nd to 2nd last as it will give out of bound if we start from first
        int start = 1, end = n - 2;

        while (start < end) {

        int mid = (start + end) / 2;

        //Checking whether peak element is in middle position
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            return arr[mid];

       /* Now we need to check on which half our peak lies , that we can
         check by seeing positioning of mid
         If mid is > mid-1 means mid is on increasing curve , means peak on on right
         so lets eliminate left half

         This approach will work for multiple peaks also

          */
        if (arr[mid] > arr[mid - 1])
            start = mid + 1;

        else
            end = mid - 1;
    }
      return -1;
    }

    public static void main(String[] args) {


    }
}
