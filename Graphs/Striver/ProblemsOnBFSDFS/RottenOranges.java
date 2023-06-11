/*You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

        Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4
*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private static class Pair {
        int row;
        int column;
        int time;

        public Pair(int row, int column, int time ) {
            this.row = row;
            this.column = column;
            this.time=time;
        }
    }


    //only bsf can be used

    private static int rottenOrange(int[][] grid) {
        //take the grid sizes
        int n = grid.length;
        int m =grid[0].length;

        int countFresh=0;

        //now get all the rotten oranges and put them in queue
        Queue<Pair> pendingOranges=new LinkedList<>();
        //create the visited array and travel across the grid and get all the oranges that are rotten
        int[][] visited=new int[n][m];
        for(int i=0; i < n; i++){
            for(int j=0; j < m ; j++){
                //now if index is rotten , please pick them and add with the current time
                if(grid[i][j]==2){
                    pendingOranges.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                //track all fresh oranges
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int time =0;

        // delta row and delta column
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        //count of oranges pushed in queue
        int count=0;

        while(!pendingOranges.isEmpty()){
            int r =pendingOranges.peek().row;
            int c=pendingOranges.peek().column;
            int t=pendingOranges.peek().time;
            pendingOranges.poll();
            time= Math.max(time, t);//time = t also works

            //now lets visit  all the  4 neighbouring guys

            // exactly 4 neighbours
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                // check for valid coordinates and
                // then for unvisited fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    // push in queue with timer increased
                    pendingOranges.add(new Pair(nrow, ncol, t + 1));
                    // mark as rotten
                    visited[nrow][ncol] = 2;
                    //increase the count of oranges pushed in queue
                    count++;

                }
            }

        }
        // check if  fresh oranges found in grid are equal to
        if(count!=countFresh){
           return -1;
        }
        return time;

    }


    public static void main(String[] args) {

     int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottenOrange(grid));
    }


}
