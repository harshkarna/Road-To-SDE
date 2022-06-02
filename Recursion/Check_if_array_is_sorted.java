package com.Recursion;

public class Check_if_array_is_sorted {

    public static boolean check_sorted_1(int arr[]) {
        if (arr.length <= 1) {
            return true;
        }

        int small_case_arr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            small_case_arr[i - 1] = arr[i];
        }

        boolean smallcase=check_sorted_1(small_case_arr);
        if(!smallcase){
            return false;
        }
        if (arr[0]<=arr[1]){
            return true;
        }
        else{
            return false;
        }
    }


    public static boolean check_sorted_2(int arr[]) {
        if (arr.length <= 1) {
            return true;
        }

        if(arr[0]>arr[1]){
            return false;
        }

        int small_case_arr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            small_case_arr[i - 1] = arr[i];
        }
        boolean smallcase=check_sorted_1(small_case_arr);
        return smallcase;

    }


    public static void main(String[] args) {
        int arr[]={2,1,3,4,5};
        System.out.println( check_sorted_1(arr));

    }
}
