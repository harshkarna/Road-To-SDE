package com.Recursion;

public class Sum_of_array_1 {

    //better solution as we are not using new array space at every recursive call

    public static int sum_array(int arr[],int startIndex){
        if(startIndex==arr.length-1){
            return arr[startIndex];
        }

        int smallcase=sum_array(arr,startIndex+1);
        return arr[startIndex]+smallcase;

    }


    public static void main(String[] args) {

        int arr[]={1,2,1};
        System.out.println(sum_array(arr,0));
    }
}
