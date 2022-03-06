package com.Recursion;

public class Sum_of_array_1 {

    //better solution as we are not using new array space at every recursive call

    public static int sum_array(int arr[],int startIndex){

        //taking base class as 1

        if(startIndex==arr.length-1){
            return arr[startIndex];
        }

        int smallcase=sum_array(arr,startIndex+1);
        return arr[startIndex]+smallcase;

    }
    public static int sum_array_1(int arr[],int startIndex){

        //taking base class as 0

        if(startIndex==arr.length){
            return 0;
        }

        int smallcase=sum_array(arr,startIndex+1);
        return arr[startIndex]+smallcase;

    }


    public static void main(String[] args) {

        int arr[]={1,2,5};
        System.out.println(sum_array_1(arr,0));
    }
}
