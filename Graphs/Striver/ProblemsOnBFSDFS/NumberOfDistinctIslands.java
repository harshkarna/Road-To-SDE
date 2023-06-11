/*Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands
where a group of connected 1s (horizontally or vertically) forms an island.
Two islands are considered to be distinct if and only if one island is not
equal to another (not rotated or reflected).

        Example 1:

        Input:
        grid[][] = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}}
        Output:
        1
        Explanation:
        grid[][] = {{1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}}
        Same colored islands are equal.
        We have 2 equal islands, so we
        have only 1 distinct island.
        */
package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    private static class Pair {
        int row;
        int column;

        public Pair(int row, int column ) {
            this.row = row;
            this.column = column;

        }
    }

    private static void dfs(int row, int col, int[][] visited, int[][] grid,
                            ArrayList<Pair> list, int baseRow , int baseCol) {
      visited[row][col]=1;
      //add the shape in list
      list.add(new Pair(row-baseRow,col-baseCol));

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol,visited, grid ,list,baseRow, baseCol);
            }
        }

    }

   public static int countDistinctIslands(int[][] grid) {
       //get the dimensions
       int n = grid.length;
       int m = grid[0].length;
       //create the visited array
       int[][] visited=new int[n][m];

       //need one set to store  all the distinct paths
       Set<ArrayList<Pair>> set=new HashSet<>();
       //now traverse over the grid to find that starting point of land , so that we \
       //can call DFS on it
       for(int row= 0; row < n ;row++){
           for(int col=0; col< m;col++){
               if(visited[row][col] ==0 && grid[row][col]==1){
                   //for every distinct we need list to store shape
                   ArrayList<Pair> list =new ArrayList<>();
                   dfs(row, col,visited, grid ,list,row, col);
                   //store the list received in set in order get distinct shaper only
                   set.add(list);
               }
           }
       }
       return set.size();
    }


    public static void main(String[] args) {
       int  grid[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};

       int ans =countDistinctIslands(grid);
        System.out.println(ans);



    }
}
