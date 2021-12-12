



package com.Array;

import java.util.Scanner;

public class ArrayRevision {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int size =sc.nextInt();
        int arr[] =new int[size];

        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

//        for(int i=0;i<size;i++){
//            System.out.print(arr[i]);
//        }

        int sum=0;
        for(int i=0;i < arr.length;i++){
            sum=sum+arr[i];
        }
        System.out.println("Sum is =" + sum);
        System.out.println("Sum is =" + sum);


    }
}
