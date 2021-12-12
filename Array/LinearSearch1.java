package com.Array;

import java.util.Scanner;

public class LinearSearch1 {


    public static void linearSearch(int[] arr, int toSearch) {
        boolean flag=false;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==toSearch){
                System.out.println(i);
                break;
            }
            flag=true;
        }
        if(flag){
            System.out.println(-1);
        }
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

         linearSearch(arr,toSearch);



    }
}
