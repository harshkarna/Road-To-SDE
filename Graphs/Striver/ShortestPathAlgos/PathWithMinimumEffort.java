/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down,
 left, or right, and you wish to find a route that requires the minimum effort.

        A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
        Example 1:
        heights = [[1,2,2],[3,8,2],[5,3,5]]
        Output: 2
        Explaination: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is
         better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static class tuple {
        int distance, row , column;
        tuple(int distance, int row, int column) {
            this.distance = distance;
            this.row = row;
            this.column = column;
        }
    }

    public static int  MinimumEffort(int heights[][]) {

        PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new tuple(0, 0, 0));

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};


        while(!pq.isEmpty()) {
            tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int r = it.row;
            int c = it.column;


            // Check if we have reached the destination cell,
            // return the current value of difference (which will be min).
            if (r == n - 1 && c == m - 1) return diff;

            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                // Checking the validity of the cell and updating if dist is shorter.
                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {

                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = Math.max( Math.abs(heights[r][c] - heights[newr][newc]), diff);

                    // If the calculated effort is less than the prev value in dist array
                    // we update as we need the min effort.
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        // If the destination is unreachable.
        return 0;
    }

    public static int MinimumEffort_v1(int heights[][]) {
        PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the dist for source cell (0,0) as 0.
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new tuple(0, 0, 0));

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        int dest_min=Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int r = it.row;
            int c = it.column;


            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                // Checking the validity of the cell and updating if dist is shorter.
                if (newr >= 0 && newr < n && newc >= 0 && newc < m) {

                    // Effort can be calculated as the max value of differences
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = Math.max( Math.abs(heights[r][c] - heights[newr][newc]), diff);

                    // If the calculated effort is less than the prev value in dist array
                    // we update as we need the min effort.
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        if(newr == n - 1 && newc == m - 1){
                            dest_min =Math.min(dest_min, dist[newr][newc]);
                        }
                        pq.add(new tuple(newEffort, newr, newc));
                    }
                }
            }
        }
        if(dest_min!=Integer.MAX_VALUE){
            return dest_min;
        }
        // If the destination is unreachable.
        return 0;
    }


    public static void main(String[] args) {
//        int[][] heights={{1,2,2},{3,8,2},{5,3,5}};
        int[][] heights={{1,10,6,7,9,10,4,9}};

        System.out.println(MinimumEffort(heights));
        System.out.println(MinimumEffort_v1(heights));




    }
}
