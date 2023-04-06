/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row
 and column to 0's.

        You must do it in place.

        Example 1:

        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]


*/


package com.SDESheet.Arrays.Medium;



public class SetMatrixZero {

    /*
    BruteForce Approach :
    1 Iterate the array , where ever its o , go to that i and j , and mark everyone like -1 , but not 0 straightaway,
    because if you put everyone as zero , then how will you figure out whats the initial zeros were .
    2. So better first mark -1 to all col and rows in which zero lies , dont touch the existing zero ones.
    3.At last mark all -1 to 0 and hence solved

    TO(  n*m  * (n+m)  + (n*m))  --- near about n3

    *  */
    public static void SetMatrixZero_Brute(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0; i < rows;i++){
            for(int j=0; j < cols;j++){
                if(arr[i][j]==0){
                    markRow(i,arr);
                    markCol(j,arr);
                }
            }
        }
        for(int i=0; i < rows;i++){
            for(int j=0; j < cols;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }

    }
    private static void markRow(int i,int[][] arr ) {
        for(int j=0;j<arr.length;j++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }
    private static void markCol(int j,int[][] arr) {
        for(int i=0;i<arr[0].length;i++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }


    /*
   Approach 2 : Keeping track
   So instead of marking all 0 at that particular i and j , lets just keep track .
   and at the end we will mark all

   TO( 2 *n*m)
   SO(O(n) +o(M))
    */

    public static void SetMatrixZero_Better(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;

        //Take these 2 arrays for keeping tarck
        int[] colArray=new int[cols];
        int[] rowArray=new int[rows];

        for(int i=0; i < rows;i++){
            for(int j=0; j < cols;j++){
                if(arr[i][j]==0){
                    rowArray[i]=1;
                    colArray[j]=1;
                }
            }
        }

        for(int i=0; i < rows;i++){
            for(int j=0; j < cols;j++){
                if(rowArray[i] ==1 || colArray[j]==1){
                    arr[i][j]=0;
                }
            }
        }

    }


    public static void main(String[] args) {

        int[][] arr={{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

//        SetMatrixZero_Brute(arr);
        SetMatrixZero_Better(arr);

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
