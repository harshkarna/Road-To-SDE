package com.Two_Dimensional_Array;

import java.util.Scanner;

public class Search_in_a_2DMatrix {

    public static int binarySearch(int[][] arr,int target){

        int row=arr.length;
        int col=arr[0].length;

        int start=0;
        int end=row *col -1;


        while(start<=end) {
            int mid = (start + end) / 2;
            int element = arr[mid/col][mid%col];

            if (element == target) {
                System.out.println("element found");
                return 1;
            } else if (element < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println("element not found");
        return -1;
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

        System.out.println("Plz enter target");

        int target = sc.nextInt();

        binarySearch(arr,target);


    }
}
