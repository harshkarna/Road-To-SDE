/*
      Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
        The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the
        row number and column number of the current cell, and i2, j2 are the row number
         and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.
*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving0_1 {

    private static class Pair {
        int row;
        int column;
        int distance;

        public Pair(int row, int column, int distance ) {
            this.row = row;
            this.column = column;
            this.distance=distance;
        }
    }


    public  static int[][] nearest(int[][] grid)
    {
        int n =grid.length;
        int m =grid[0].length;

        int[][] visited=new int[n][m];
        int[][] distance =new int[n][m];

        Queue<Pair> pendingOnes=new LinkedList<>();

        for(int i=0;i< n ;i++){
            for(int j=0; j < m;j++){
                //traverse over the grid and find all the ones
                if(grid[i][j]==1){
                   pendingOnes.add(new Pair(i,j,0));
                   visited[i][j]=1;
                }
                else{
                    //this else part not required
                    visited[i][j]=0;

                }
            }
        }

        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};

        while(!pendingOnes.isEmpty()){
            int row =pendingOnes.peek().row;
            int col=pendingOnes.peek().column;
            int dist=pendingOnes.peek().distance;
            pendingOnes.poll();

            //mark the current element dist in the dist array
            distance[row][col]=dist;

            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 ) {
                    visited[nrow][ncol] =1;
                    pendingOnes.add(new Pair(nrow,ncol,dist+1));

                }
            }

        }
        return distance;

    }

    public static void main(String[] args) {

      int[][] grid=  {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
      int[][] output=nearest(grid);
        int rows=output.length;
        int cols=output[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }


    }
}
