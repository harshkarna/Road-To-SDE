package com.SDESheet.BinarySearch.Arrays_1D;

public class NumberOfOccureneces {

    public static int lowerBound(int arr[], int n, int x) {
        int low=0;
        int high =n-1;
        //by default if nothing is found
        int ans=n;

        while (low <=high){
            int mid =(low+high)/2;
            //may be an answer, on left side , so store mid in ans and move high to mid-1
            if(arr[mid] >= x){
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

    public static int upperBound(int arr[], int n, int x){
        int low=0;
        int high =n-1;
        //by default if nothing is found
        int ans=n;

        while (low <=high){
            int mid =(low+high)/2;
            //may be an answer, on left side , so store mid in ans and move high to mid-1
            if(arr[mid] > x){
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

    public static int[] firstAndLastPosition(int arr[], int n, int k) {
        int lb =lowerBound(arr, n, k);
        if(lb==n || arr[lb] !=k) return new int[] {-1, -1};
        return new int[] {lb, upperBound(arr, n, k) -1};
    }

    public static int count(int arr[], int n, int x) {
        int[] ans=new int[2];
        ans=firstAndLastPosition(arr,n,x);
        if(ans[0]== -1) return 0;
        return ans[1]-ans[0]+1;

    }

    public static void main(String[] args) {


    }


}
