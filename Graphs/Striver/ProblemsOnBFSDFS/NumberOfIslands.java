/*Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land).
 Find the number of islands.

        Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally
        or vertically or diagonally i.e., in all 8 directions.

        Example 1:

        Input:
        grid = {{0,1},{1,0},{1,1},{1,0}}
        Output:
        1
        Explanation:
        The grid is-
        0 1
        1 0
        1 1
        1 0
        All lands are connected.*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    private static void bfs(int row, int col, boolean[][] visited, int[][] grid) {
        visited[row][col]=true;
        Queue<Pair> pendingVertices=new LinkedList<>();
        pendingVertices.add(new Pair(row, col));

        int n =grid.length;
        int m =grid[0].length;

        while(!pendingVertices.isEmpty()){
            int currentRow=pendingVertices.peek().first;
            int currentCol=pendingVertices.peek().second;
            pendingVertices.poll();

            //traverse in current i and j ;s neighbour in all possible directions
            // and if u find 1 , mark visited
             for(int delrow=-1;  delrow<=1; delrow++){
                 for(int delcol=-1; delcol<=1;delcol++){
                     //neighbour rows and cols
                     int nrow=currentRow + delrow;
                     int ncol=currentCol + delcol;

                     //check if nrow and ncol is within grid
                     if(nrow>= 0 && nrow < n && ncol>=0 && ncol< m
                         && grid[nrow][ncol]==1 && !visited[nrow][ncol]){
                            visited[nrow][ncol]=true;
                            pendingVertices.add(new Pair(nrow, ncol));
                     }

                 }
             }

        }

    }


    public static int numIslands(int[][] grid) {
          int n = grid.length;
          int m = grid[0].length;
          int count=0;
          //create a visited array
          boolean[][] visited=new boolean[n][m];
          //now traverse over the grid to find that starting point of land , so that we \
          //can call DFS on it
          for(int row= 0; row < n ;row++){
               for(int col=0; col< m;col++){
                   if(!visited[row][col] && grid[row][col]==1){
                       count++;
                       bfs(row, col,visited, grid);
                   }
               }
        }
         return count;
    }


    public static void main(String[] args) {

        int[][] grid= {{0,1,1,0},{0,1,1,0},{0,0,0,0},{1,1,0,1}};
        System.out.println(numIslands(grid));


    }


}
