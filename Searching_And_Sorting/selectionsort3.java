package com.Searching_And_Sorting;

import java.util.Scanner;

public class selectionsort3 {


    public static void selectionsort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            //insert element at ith position
            int min= Integer.MAX_VALUE;
            int minIndex=-1;
            for (int j=i;j<arr.length;j++){
                if(arr[j]< min){
                    min=arr[j];///doubt
                    minIndex=j;
                }
            }
            //swap elements at min Index with Ith element
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;

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
        selectionsort(arr);

    }
}
