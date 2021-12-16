package com.Searching_And_Sorting;

public class RotateArray1 {


    public static int[] rotatearray(int arr[],int toRotate){
        int k=0;
        int arr1[]=new int[arr.length];


        int i=toRotate;
        while(i< arr.length){
            arr1[k]=arr[i];
            i++;
            k++;
        }
        i=0;
        while(k< arr1.length && i<toRotate){
            arr1[k]=arr[i];
            k++;
            i++;
        }

        return arr1;
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
