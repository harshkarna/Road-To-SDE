//Largest Row or Column
//
//        For a given two-dimensional integer array/list of size (N x M),
//        you need to find out which row or column has the largest sum(sum of all the elements in a row/column) amongst all the rows and columns.
//        Note :
//        If there are more than one rows/columns with maximum sum, consider the row/column that comes first.
//        And if ith row and jth column has the same largest sum, consider the ith row as answer.
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
//        For each test case, If row sum is maximum, then print: "row" <row_index> <row_sum>
//        OR
//        If column sum is maximum, then print: "column" <col_index> <col_sum>
//        It will be printed in a single line separated by a single space between each piece of information.
//
//        Output for every test case will be printed in a seperate line.
//        Consider :
//        If there doesn't exist a sum at all then print "row 0 -2147483648", where -2147483648 or -2^31 is the smallest value for the range of Integer.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= N <= 10^3
//        0 <= M <= 10^3
//        Time Limit: 1sec
//        Sample Input 1 :
//        1
//        2 2
//        1 1
//        1 1
//        Sample Output 1 :
//        row 0 2
//        Sample Input 2 :
//        2
//        3 3
//        3 6 9
//        1 4 7
//        2 8 9
//        4 2
//        1 2
//        90 100
//        3 40
//        -10 200
//        Sample Output 2 :
//        column 2 25
//        column 1 342
package com.Two_Dimensional_Array;

import java.util.Scanner;

public class Largest_Row_or_Column {
    public static void largestRoworColumn(int[][] arr){

        int sum_row=0;
        int row_index=0;
        int max_row=Integer.MIN_VALUE;
        int sum_column=0;
        int col_index=0;
        int max_column=Integer.MIN_VALUE;

        //for row
        for(int i=0;i<arr.length;i++) {
            sum_row=0;
            for (int j = 0; j < arr[0].length; j++) {
                sum_row=sum_row+arr[i][j];
            }
            if(sum_row>max_row){
                max_row=sum_row;
                row_index=i;
            }
        }

        //for Column
        for(int j=0;j<arr[0].length;j++) {
            sum_column=0;
            for (int i = 0; i < arr.length; i++) {
                sum_column=sum_column+arr[i][j];
            }
            if(sum_column>max_column){
                max_column=sum_column;
                col_index=j;
            }
        }

        if(max_row>=max_column){
            System.out.println("row "+row_index+" "+max_row);
        }
        else{
            System.out.println("column "+col_index+" "+max_column);
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
                System.out.println("Enter the element at "+ i +" row "+j+" columns");
                arr[i][j]=sc.nextInt();

            }
        }
        largestRoworColumn(arr);

    }
}
