/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
         DO NOT allocate another 2D matrix and do the rotation.

        Example 1:

        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]
*/

package com.SDESheet.Arrays.Medium;

public class RotateImageOrMatrix {

    /* Approach :
    *Try to observe patterns like where a particular i , j is going
    * like
    * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
      Output: [[7,4,1],[8,5,2],[9,6,3]]
      *      old i,j   new i,j
        here - > 0,0 --- >0,2
    *            0,1 --- >1,2
    *            0,2 --- >2,2
    *
    * here we can see that first row is becoming last columns , hence second row will become second last column
    * so every i is converting to (n-1) -i  for j and every j is converting to i in transformed array
    *
    * TO(n*m)
    * SO(N*m) --using extra a  space , can we optimise?
    * */

    public static int[][] rotateMatrix_Brute(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;

        int[][] ans=new int[rows][cols];

        for(int i=0; i < rows;i++) {
            for(int j=0; j < cols;j++){
                ans[j][(rows-1)-i]=arr[i][j];
                }
            }
        return ans;
    }


    /*
    * Approach 2 :   Doing in-place without extra space
    * Observing the pattern
    * So if you see carefully  if you transpose the matrix and then reverse its every row
    * you get the desired result
    * -- Transposing a matrix means rows becomes rows and col becomes roes
    * -- Thing to notice is that diagonal remain same
    * -- and if you just take upper half above diagonal and swap every i ,j to j , i , its transposed
    *  so lets take an example
    *    0 1 2 3
    * 0  1 2 3 4      transpose          1 5 9 13
    * 1  5 6 7 8      --------->         2 6 10 14
    * 2  9 10 11 12                      3 7 11 15
    * 3  13 14 15 16                     4 8 12 16
    *
    *
    * so here
    * 0,1  ----> 1,0
    * 0,2  ----> 2,0
    * 0,3  ----> 3,0
    * 1,2  ----> 2,1
    * 1,3  ----> 3,1
    * 2,3  ----> 3,2
    *
    * so we can observe i is going from  0 to n-2  and j is going from i+1 to n-1 for every row /col transpose
    *
    *
    *
    *  */

    public static void  rotateMatrix_Optimal(int[][] arr){
        int rows=arr.length;
        int cols=arr[0].length;
        int temp;
        //transpose the matrix
        //T0(n/2  * n/2)
        for(int i=0; i < rows - 1 ;i++) {
            for(int j=i+1; j < cols;j++){
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // reverse each row
        //To(n* m/2)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][ (rows - 1 ) - j];
                arr[i][(rows -1) - j] = temp;
            }
        }

    }


    public static void main(String[] args) {
    int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
//    int[][] output=rotateMatrix_Brute(arr);
    rotateMatrix_Optimal(arr);
    int rows=arr.length;
    int cols=arr[0].length;

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
