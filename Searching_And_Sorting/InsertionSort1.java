package com.Searching_And_Sorting;

import java.util.Scanner;

public class InsertionSort1 {

    public static void insertionsort(int arr[]){
        for (int i=1;i< arr.length;i++){
            int j=i-1;
            int temp=arr[i];
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        //display of array
        for(int i=0;i <arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in Array");
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        System.out.println("Enter the  elements of Array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        insertionsort(arr);
    }
}
