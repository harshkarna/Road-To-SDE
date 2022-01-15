package com.Two_Dimensional_Array;

import java.util.Scanner;

public class LinearSearchIn2DArray {

    public static boolean isPresent(int arr[][],int target){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;i++){
                if(arr[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no.of Rows");
        int rows=sc.nextInt();
        System.out.println("Enter the no.of Cols");
        int cols=sc.nextInt();

        int[][] arr =new int[rows][cols];

        //Take input from array
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("Enter the element at "+i+" row "+j+" columns");
                arr[i][j]=sc.nextInt();
            }
        }
        int target=7;
        if(isPresent(arr,target)){
            System.out.println("found");
        }
        else{
            System.out.println("not found");
        }

    }

}
