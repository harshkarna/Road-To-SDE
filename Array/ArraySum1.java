package com.Array;

import java.util.Scanner;

public class ArraySum1 {
    public static void main(String[] args) {

        int sum=0;

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //display of array
        for(int i=0;i < size; i++){
            sum=sum+arr[i];
            System.out.print(arr[i]+" ");

        }
        System.out.println("The sum of all elements is " + sum);
    }
}
