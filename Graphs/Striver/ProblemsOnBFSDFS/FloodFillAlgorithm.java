/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

        You are also given three integers sr, sc, and color. You should perform a flood fill on the image
        starting from the pixel image[sr][sc].

        To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to
        the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally
        to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned
        pixels with color.

        Return the modified image after performing the flood fill.

        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]
        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
        all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels)
        are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.


*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

public class FloodFillAlgorithm {

    private static void dfs(int row, int col, int[][] ans, int[][] image , int newColor, int initialCol) {
        ans[row][col] = newColor;
        int n =image.length;
        int m =image[0].length;
        // exactly 4 neighbours
        // delta row and delta column
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            //see if nrow and ncol are not crossing grid boundary
            // and we need to call dfs on which i,j in given grid is old colour
            //and same for given i, j in ans array is yet not new coloured
             if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
              image[nrow][ncol]==initialCol && ans[nrow][ncol]!=newColor){
                 dfs(nrow,ncol,ans, image,newColor,initialCol);
             }

        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
         //lets keep the initial colour
        int initialCol=image[sr][sc];
        //copy the original image grid, as we need to return the modified grid
        int[][] ans=image;

        //call dfs
        dfs(sr,sc,ans, image,color,initialCol);
        return ans;

    }

    public static void main(String[] args) {

        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        int[][] arr =floodFill(image, sr, sc, color);
        //display 2D Array
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
