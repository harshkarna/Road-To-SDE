package com.Array;

import java.util.Scanner;

public class LinearSearch2 {

    public static int linearSearch(int arr[],int toSearch){
        for(int i=0;i< arr.length;i++){
            if(arr[i]==toSearch){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int toSearch= sc.nextInt();
        System.out.println(linearSearch(arr,toSearch));

    }
}
