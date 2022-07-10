//Code: N Queens
//
//        You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
//        Input Format :
//        Line 1 : Integer N
//        Output Format :
//        One Line for every board configuration.
//        Every line will have N*N board elements printed row wise and are separated by space
//        Note : Don't print anything if there isn't any valid configuration.
//        Constraints :
//        1<=N<=10
//        Sample Input 1:
//        4
//        Sample Output 1 :
//        0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
//        0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0

package com.Backtracking;

public class N_Queen_Problems {

    public static void placeNQueens(int n){
        int board[][]=new int[n][n];
        placeQueens(n,0);
    }

    private static void placeQueens(int n, int row) {
        if(row== n){
            //valid Board Configuartion
        }

        //Check for all columns
         //check if its safe to place queen
            //if its safe -> then place the queen and move to next row

    }


    public static void main(String[] args) {


    }

}
