package com.Recursion;

import javax.swing.*;

public class Check_if_array_is_sorted_1 {

    //better solution as we are not using new array space at every recursive call


    private static boolean check_sorted(int arr[], int startIndex){
        //making this function as private becasue it is internal

        if(startIndex==arr.length-1){ //base case
            return true;
        }

        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }

        boolean smallcase=check_sorted(arr,startIndex+1);
        return smallcase;

    }


    //doing function overloading as we dont want user at line 36
    //to give startindex value
    public static boolean check_sorted(int arr[]){

        return check_sorted(arr,0);
    }

    public static void main(String[] args) {

        int arr[]={1,2,2,2,3};
        System.out.println(check_sorted(arr));
    }
}
