package com.Array;

public class SwapAlternate2 {


    public static int[] swapalternate(int arr[]){
         int temp=0;
         for(int i=0;i< arr.length-1;i=i+2){
             temp=arr[i];
             arr[i]=arr[i+1];
             arr[i+1]=temp;
         }
         return arr;
    }


    public static void main(String[] args) {
        int arr[] ={9,3,12,6,4,32,7};
        int arr1[]=swapalternate(arr);

        //display of array
        for(int i=0;i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }



    }


}
