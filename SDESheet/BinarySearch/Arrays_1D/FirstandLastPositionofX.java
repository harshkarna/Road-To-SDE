package com.SDESheet.BinarySearch.Arrays_1D;

import java.util.ArrayList;

public class FirstandLastPositionofX {

    //we can use  raw binary search or else we can use lower bound for 1st occurrence and upperbound -1 for last occurrence
    //using lower bound also keep things for edge cases like if k is not present etc.
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low=0;
        int high =n-1;
        //by default if nothing is found
        int ans=n;

        while (low <=high){
            int mid =(low+high)/2;
            //may be an answer, on left side , so store mid in ans and move high to mid-1
            if(arr.get(mid) >= x){
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

    public static int upperBound(ArrayList<Integer> arr, int n, int x){
        int low=0;
        int high =n-1;
        //by default if nothing is found
        int ans=n;

        while (low <=high){
            int mid =(low+high)/2;
            //may be an answer, on left side , so store mid in ans and move high to mid-1
            if(arr.get(mid) > x){
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

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int lb =lowerBound(arr, n, k);
        if(lb==n || arr.get(lb) !=k) return new int[] {-1, -1};
        return new int[] {lb, upperBound(arr, n, k) -1};

    }

    public static void main(String[] args) {

    }
}
