package com.Two_Dimensional_Array;

import java.util.Scanner;

public class Input_And_Print {


    public static void print2DArray(int[][] arr){
        //display 2D Array
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] takeInput(){
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
        return arr;
    }

    public static void main(String[] args) {

        int[][] input=takeInput();
        print2DArray(input);

    }
}
