package com.SDESheet.BinarySearch.Arrays_1D;

public class FloorAndCeil {

    //floor in sorted Array - > largest number in array < = x (this is nothing but reverse of  lower bound algo)
    //cei in sorted array - > smallest number in array > = x (this is nothing but lower bound algo)

//    Pair getFloorAndCeil(int[] arr, int n, int x) {
//
//
//    }

    public static int floor(int[] arr,int n,int x)
    {
        int low = 0,high=n-1,ans=-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }

    public static int ceil(int[] arr,int n,int x)
    {
        int low = 0,high=n-1,ans=-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {


    }
}
