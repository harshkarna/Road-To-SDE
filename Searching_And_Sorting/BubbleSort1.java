package com.Searching_And_Sorting;

import java.util.Scanner;

public class BubbleSort1 {

///Correct code for bubble sort
    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            //each iteration will push max element at last
            for(int j=0;j<arr.length-i-1;j++){ // -i bcoz of not comparing elemnets again n again and n-1 bcoz at last we want 2 elements to be compared
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
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
        bubblesort(arr);
    }
}
