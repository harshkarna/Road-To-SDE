package com.SDESheet.BinarySearch.Arrays_1D;

public class BinarySearch_recursive {

    public static int recursive(int nums[],int low, int high, int target) {
            if(low <=high) return -1 ;
            int mid =(low+high)/2;
            if(nums[mid]==target) return mid;
            else if(target > nums[mid])  return recursive(nums, mid+1, high, target) ;
            return recursive(nums, low, mid-1, target);
    }


    public static void main(String[] args) {
        int nums[]={1,2,3,4,5,7};
        System.out.println(recursive(nums,0, nums.length, 4));

    }
}
