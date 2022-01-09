package com.Two_Dimensional_Array;

import java.util.Scanner;

public class Largest_Column_Sum {


    public static void largestColumnSum(int[][] arr){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int j=0;j<arr[0].length;j++) {
            sum=0;
            for (int i = 0; i < arr.length; i++) {
                sum=sum+arr[i][j];
            }
            if(sum>max){
                max=sum;
            }
        }
        System.out.println(max);
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
        largestColumnSum(arr);
    }
}
