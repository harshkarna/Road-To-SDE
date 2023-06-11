//Given a sorted array Arr[](0-index based) consisting of N distinct integers and an integer k, the task is to find the index of k, if its present in the array Arr[]. Otherwise, find the index where k must be inserted to keep the array sorted.
//
//
//        Example 1:
//
//        Input:
//        N = 4
//        Arr = {1, 3, 5, 6}
//        k = 5
//        Output: 2
//        Explaination: Since 5 is found at index 2
//        as Arr[2] = 5, the output is 2.
//

package com.SDESheet.BinarySearch.Arrays_1D;

public class SearchInsertPosition {

    //this is lower bound problem , just asked in a different way

    static int searchInsertK(int Arr[], int N, int k)
    {
        int low=0;
        int high =N-1;
        //by default if nothing is found
        int ans=N;

        while (low <=high){
            int mid =(low+high)/2;
            //may be an answer, on left side , so store mid in ans and move high to mid-1
            if(Arr[mid] >= k){
                ans=mid ;
                //look for more smallest index on left
                high =mid-1;
            }
            else {
                low=mid+1;// look for right
            }
        }
        return ans;
    }


    public static void main(String[] args) {


    }
}
