package com.Searching_And_Sorting;

public class RotateArray1 {

    //// Better solution
    public static int[] rotatearray(int arr[],int toRotate){

        int n = arr.length;
        for(int i=0;i<toRotate;i++){
            int temp=arr[0];
            for(int j=0;j< n-1;j++){
                arr[j]=arr[j+1];
            }
            arr[n-1]=temp;
        }
        return arr;

    }

        public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7};
        int toRotate=2;
        int arr1[]= rotatearray(arr,toRotate);

        //display of array
        for(int i=0;i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
    }
}
