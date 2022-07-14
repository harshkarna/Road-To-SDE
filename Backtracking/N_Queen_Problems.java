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
//        0 1 0 0
//        0 0 0 1
//        1 0 0 0
//        0 0 1 0

//        0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0

package com.Backtracking;

public class N_Queen_Problems {

    public static void placeNQueens(int n) {
        int board[][] = new int[n][n];
        placeQueens(n, 0, board);
    }

    private static void placeQueens(int n, int row,int board[][]) {

        //base case
        if(row == n ){
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        //Solve 1 case and rest recusrion will solve
        //Placing queen
        for (int column = 0; column < n; column++) {
            if (canBePlaced(board, row, column, n)) {
                board[row][column] = 1;
                placeQueens(n, row + 1, board);
                board[row][column] = 0;
            }
        }

    }

    public static boolean canBePlaced(int board[][], int row, int col, int n) {
        int i = row;
        int j = col;
        //check top
        while (i >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
        }
        i = row;
        j = col;
        //check top left diag
        while (j >= 0 && i >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            j--;
            i--;
        }
        i = row;
        j = col;
        //check top right diag
        while (j < n && i>=0) {
            if (board[i][j] == 1) {
                return false;
            }
            j++;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        placeNQueens(n);

    }

}
