/*
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
        A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking
         off the boundary of the grid.\
        Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
*/


package com.Graphs.Striver.ProblemsOnBFSDFS;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    private static class Pair {
        int row;
        int col;

        public Pair(int row, int col ) {
            this.row = row;
            this.col = col;
        }
    }
    public static int  numberOfEnclaves(int[][] grid) {
        //create a queue and list the dimensions of grid
        Queue<Pair> pendingOnes = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        //create a visited array
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ////traverse over the array and if its border
                // and there is land , call bfs from that point
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        pendingOnes.add(new Pair(i, j));
                        visited[i][j] = 1;
                    }
                }

            }
        }

        //lets do the traversal from elements in queue
        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};

        while (!pendingOnes.isEmpty()) {
            int row = pendingOnes.peek().row;
            int col = pendingOnes.peek().col;
            pendingOnes.poll();

            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {

                    pendingOnes.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;

                }
            }
        }
        //at last count all the unvisited 1's
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] grid= {{0, 0, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}};

        System.out.println(numberOfEnclaves(grid));


    }

}
