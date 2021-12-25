package com.Searching_And_Sorting;

import java.util.Scanner;

public class sort012_1 {

    public static void sort012(int arr[]){

         int n = arr.length;
        int nz=0;
        int nt=n-1;
        int temp_nz=0;
        int temp_nt=0;

        for (int i =0;i<=nt;i++){
            if(arr[i]==0){
                temp_nz= arr[i];
                arr[i]=arr[nz];
                arr[nz]=temp_nz;
                nz++;
                if(i==nt){
                    break;
                }
            }
            else if (arr[i]==2){
                if (arr[i]==arr[nt]){
                    temp_nt=arr[i];
                    arr[i]=arr[nt-1];
                    arr[nt-1]=temp_nt;
                    nt=nt-2;
                    i--;

                }
                else{
                    temp_nt=arr[i];
                    arr[i]=arr[nt];
                    arr[nt]=temp_nt;
                    nt--;
                    i--;
                }
            }
       }
        //display of array
        for(int i=0;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the no. of elements in Array");
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//
//        //input in Array
//        System.out.println("Enter the  elements of Array");
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }

        int arr[]={0,1,2,1,2,1,2};
        sort012(arr);

    }
}
