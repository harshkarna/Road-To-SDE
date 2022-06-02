package com.Searching_And_Sorting;

public class Push_0_to_end_1 {

////Better Solution - without initialising additional array
    public static int[] push0toend(int arr[]){
        int nz=0;
        int temp;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                temp=arr[i];
                arr[i]=arr[nz];
                arr[nz]=temp;
                nz++;

            }
        }

        return arr;

    }


    public static void main(String[] args) {

        int arr[]={2,0,0,1,3,0,0};
        int arr1[]= push0toend(arr);

        //display of array
        for(int i=0;i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }


    }
}
