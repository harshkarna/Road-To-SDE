package com.Searching_And_Sorting;

import java.util.Scanner;

public class sort0_1 {


    public static void sort0_1(int arr[]) {

        int nz = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[nz];
                arr[nz] = temp;
                nz++;
            }
        }
        //display of array
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

            //int[] arr = {1,1,1,1,0,0,1,0,0,1,1,1,};
            int[] arr = {1,0,1,0,1};
            for(int i=0, j=arr.length-1; i <= j; ){
//                System.out.println("i: " + i + ", j:" + j);
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++; j--;
                    continue;
                }if(arr[i] == arr[j] && arr[j] == 1){
                    j--;
                    continue;
                }if(arr[j] == 0){
                    i++;
                    continue;
                }
                i++; j--;
            }
            for (int i=0; i<arr.length; i++){
                System.out.print(arr[i]+" ");
            }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the no. of elements in Array");
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//
//        //input in Array
//        System.out.println("Enter the  elements of Array");
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        sort0_1(arr);
    }
}
