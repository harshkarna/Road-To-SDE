package com.SDESheet.Arrays;

public class Check_if_array_is_sorted_and_rotated {

    public static boolean check(int[] nums) {
        // here we compare all the neighbouring element and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        int length = nums.length;

        for (int i=0; i<length-1; i++) {
            if (nums[i] > nums[i + 1]){
                irregularities ++;
            }
        }
        if(nums[length-1] > nums[0]){
            irregularities ++;
        }
        return irregularities > 1 ? false : true;
    }

    public static void main(String[] args) {
       int[] arr={1,2,3};
        System.out.println(check(arr));

    }
}
