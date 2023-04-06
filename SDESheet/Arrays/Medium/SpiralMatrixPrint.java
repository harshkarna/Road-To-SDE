//Spiral Print
//
//        For a given two-dimensional integer array/list of size (N x M), print it in a spiral form.
//        That is, you need to print in the order followed for every iteration:
//        a. First row(left to right)
//        b. Last column(top to bottom)
//        c. Last row(right to left)
//        d. First column(bottom to top)
//        Mind that every element will be printed only once.
//        Refer to the Image:
//        Alt txt
//
//        Input format :
//        The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
//        Then the test cases follow.
//
//        First line of each test case or query contains two integer values, 'N' and 'M',
//        separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.
//
//        Second line onwards, the next 'N' lines or rows represent the ith row values.
//
//        Each of the ith row constitutes 'M' column values separated by a single space.
//        Output format :
//        For each test case, print the elements of the two-dimensional array/list in the spiral form in a single line,
//        separated by a single space.
//
//        Output for every test case will be printed in a seperate line.
//        Constraints :
//        1 <= t <= 10^2
//        0 <= N <= 10^3
//        0 <= M <= 10^3
//        Time Limit: 1sec
//        Sample Input 1:
//        1
//        4 4
//        1 2 3 4
//        5 6 7 8
//        9 10 11 12
//        13 14 15 16
//        Sample Output 1:
//        1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
//        Sample Input 2:
//        2
//        3 3
//        1 2 3
//        4 5 6
//        7 8 9
//        3 1
//        10
//        20
//        30
//        Sample Output 2:
//        1 2 3 6 9 8 7 4 5
//        10 20 30

package com.SDESheet.Arrays.Medium;

public class SpiralMatrixPrint {

    /*Approach :
    *
    * */

    public static void spiral_Print(int[][] arr){

        int[] arr1 = new int[arr.length*arr[0].length];
        int k=0;
        int startingRow=0;
        int startingCol=0;
        int endingRow=arr.length-1;
        int endingCol=arr[0].length-1;

        int count=0;
        int total=arr.length*arr[0].length;

        while(count < total){
            //printing starting row
            for(int index= startingRow;count < total && index<=endingCol;index++){
                arr1[k]=arr[startingRow][index];
                k++;
                count++;
            }
            startingRow++;

            //printing ending col
            for(int index= startingRow;count < total && index<=endingRow;index++){
                arr1[k]=arr[index][endingCol];
                k++;
                count++;
            }
            endingCol--;

            //printing ending row
            for(int index= endingCol;count < total && index>=startingCol;index--){
                arr1[k]=arr[endingRow][index];
                k++;
                count++;
            }
            endingRow--;

            //printing starting col
            for(int index= endingRow;count < total && index>=startingRow;index--){
                arr1[k]=arr[index][startingCol];
                k++;
                count++;
            }
            startingCol++;
        }

        //display of array
        for(int i=0;i < arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
    }


    // approach if you dont want to take variable count

    public static void spiralPrint(int[][] arr) {
        int rowStart = 0, rowEnd = arr.length - 1;
        int columnStart = 0, columnEnd = arr[0].length - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            // Print top row
            for (int j = columnStart; j <= columnEnd; j++) {
                System.out.print(arr[rowStart][j] + " ");
            }
            rowStart++;

            // Print right column
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(arr[i][columnEnd] + " ");
            }
            columnEnd--;

            // Print bottom row
            if (rowStart <= rowEnd) {
                for (int j = columnEnd; j >= columnStart; j--) {
                    System.out.print(arr[rowEnd][j] + " ");
                }
                rowEnd--;
            }

            // Print left column
            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    System.out.print(arr[i][columnStart] + " ");
                }
                columnStart++;
            }
        }
    }




    public static void main(String[] args) {

        int[][] arr1={{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2={{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};

        spiral_Print(arr2);

    }
}
