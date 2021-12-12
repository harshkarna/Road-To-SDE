package com.Array;

import java.util.Scanner;

public class TripletSum1 {


    public static int tripletsum(int arr[],int sum){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==sum){
                        System.out.println("(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");
                        count++;
                    }
                }
            }
        }
        return count;
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

        int sum=sc.nextInt();
        System.out.println(tripletsum(arr,sum));

    }
}
