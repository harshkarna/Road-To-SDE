package com.SDESheet.BinarySearch.Arrays_1D;

public class BinarySearch_iterative {

    //to(log base 2 N)
    public static int search(int []nums, int target) {
        int n =nums.length;
        int low=0;
        int high=n-1;

        while(low <=high){
            int mid =(low+high)/2;
            if(nums[mid]==target) return mid;
            else if(target > nums[mid])  low=mid+1;
            else high=mid-1;

        }
        return -1;

    }


    public static void main(String[] args) {


    }


}
