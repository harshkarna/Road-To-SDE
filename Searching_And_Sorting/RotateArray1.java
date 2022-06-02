package com.Searching_And_Sorting;

public class RotateArray1 {

    //// Better solution
    public static int[] rotatearray(int arr[],int toRotate) {

        int n = arr.length;
        for (int i = 0; i < toRotate; i++) { //to keep repeating this process till torotate
            int temp = arr[0]; //storing first element in temp
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1]; //shifting all elements left wise
            }
            arr[n - 1] = temp;//puting the temp elemnt at last
        }
        return arr;

    }

        public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7};
        int toRotate=3;
        int arr1[]= rotatearray(arr,toRotate);

        //display of array
        for(int i=0;i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
    }
}
