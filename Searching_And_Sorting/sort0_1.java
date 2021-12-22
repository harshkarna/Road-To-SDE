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

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in Array");
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        System.out.println("Enter the  elements of Array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sort0_1(arr);
    }
}
