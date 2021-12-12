package com.Searching_And_Sorting;

import java.util.Scanner;

public class BinarySearch1 {

    public static int binarysearch(int arr[],int toSearch){
        int s=0;
        int e= arr.length-1;
        int mid;

        while(s<=e){
           mid=(s+e)/2;
           if(arr[mid]>toSearch){
               e=mid-1;
           }
           else if(arr[mid]<toSearch){
               s=mid+1;
           }
           else if (arr[mid]==toSearch){
               return mid;
            }
        }
        return -1;
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
        System.out.println("Enter To be Search ");
        int toSearch=sc.nextInt();
        System.out.println(binarysearch(arr,toSearch));

    }


}
