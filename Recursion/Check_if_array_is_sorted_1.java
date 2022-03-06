package com.Recursion;

import javax.swing.*;

public class Check_if_array_is_sorted_1 {

    //better solution as we are not using new array space at every recursive call


    public static boolean check_sorted(int arr[], int startIndex){
        if(startIndex==arr.length-1){ //base case
            return true;
        }

        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }

        boolean smallcase=check_sorted(arr,startIndex+1);
        return smallcase;

    }

    public static void main(String[] args) {

        int arr[]={1,2,2,4,3};
        System.out.println(check_sorted(arr,0));
    }
}
