package com.Array;

import java.util.Scanner;

public class ArraybyFunction {


    public static int  largestArrayElement(int arr[]){

        int max =Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int[] takeInput(){
        System.out.println("Enter the no. of elements in Array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the  elements of Array");
        //input in Array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void print(int arr[]){
        //display of array
        for(int i=0;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {

        int arr[]=takeInput();
        print(arr);
        int largest = largestArrayElement(arr);
        System.out.println("Largest Ekemnts is " + largest );
    }
}
