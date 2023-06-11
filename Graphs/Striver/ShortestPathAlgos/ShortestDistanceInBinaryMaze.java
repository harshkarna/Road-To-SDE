/*Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

        If the path is not possible between source cell and destination cell, then return -1.

        Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right. The source and destination cell are based on the zero based indexing.

        Example 1:

        Input:

        grid[][] = {{1, 1, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {1, 0, 0, 1}}
        source = {0, 1}
        destination = {2, 2}
        Output:
        3

        */
package com.Graphs.Striver.ShortestPathAlgos;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    private static class Pair {
        int first;// dist
        int second;// i
        int third;// j

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third= third;
        }
    }


//    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
//
//        //in this case Q also will work as every cell is 1 unit apart from each other
//        Queue<Pair> pq=new LinkedList<>();
//        int n =grid.length;
//        int m =grid[0].length;
//        int[][] dist=new int[n][m];
//        for(int i =0; i < n ; i++){
//            for(int j =0; j < m ;j++){
//                dist[i][j]=(int)(1e9);
//            }
//        }
//        dist[source[0]][source[1]]=0;
//
//
//    }

    public static void main(String[] args) {


    }
}
