//Row Wise Sum
//
//        For a given two-dimensional integer array/list of size (N x M), find and print the sum of each of
//        the row elements in a single line, separated by a single space.
//        Input Format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space.
//        They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.
//
//        Second line onwards, the next 'N' lines or rows represent the ith row values.
//
//        Each of the ith row constitutes 'M' column values separated by a single space.
//        Output Format :
//        For each test case, print the sum of every ith row elements in a single line separated by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= N <= 10^3
//        0 <= M <= 10^3
//        Time Limit: 1sec
//        Sample Input 1:
//        1
//        4 2
//        1 2
//        3 4
//        5 6
//        7 8
//        Sample Output 1:
//        3 7 11 15
//        Sample Input 2:
//        2
//        2 5
//        4 5 3 2 6
//        7 5 3 8 9
//        4 4
//        1 2 3 4
//        9 8 7 6
//        3 4 5 6
//        -1 1 -10 5
//        Sample Output 2:
//        20 32
//        10 30 18 -5

package com.Two_Dimensional_Array;

import java.util.Scanner;

public class Row_Wise_Sum {

    public static void rowWiseSum(int[][] arr){

        int sum=0;
        for(int i=0;i<arr.length;i++) {
            sum=0;
            for (int j = 0; j < arr[0].length; j++) {
                sum=sum+arr[i][j];
            }
            System.out.print(sum+" ");
        }
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
        rowWiseSum(arr);


    }
}
