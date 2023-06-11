/*
Given a matrix mat of size N x M where every element is either O or X.
        Replace all O with X that are surrounded by X.
        A O (or a set of O) is considered to be surrounded by X if there are X at locations just below, just above, just left and just right of it.

        Example 1:

        Input: n = 5, m = 4
        mat = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'O', 'X', 'X'},
        {'X', 'X', 'O', 'O'}}
        Output: ans = {{'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'X'},
        {'X', 'X', 'O', 'O'}}
        Explanation: Following the rule the above
        matrix is the resultant matrix.
*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

public class SurroundedRegions {

    private static void dfs(int row, int col, int[][] visited, char[][] mat, int[] delrow,int[] delcol ) {
        visited[row][col]=1;
        //check for top, bottom , left and right

        int n =mat.length;
        int m =mat[0].length;
        // exactly 4 neighbours
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    visited[nrow][ncol]==0 && mat[nrow][ncol]=='O'){
                dfs(nrow,ncol,visited, mat,delrow,delcol);
            }

        }

    }

    static char[][] fill(int n, int m, char mat[][])
    {
        //first you need a visited array
        int[][] visited=new int[n][m];
        //Now we need to traverse over the borders

        // delta row and delta column
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};

        //traverse first row and last row
        for(int j=0;j<m ;j++){
            // traverse first row
            if(visited[0][j]==0  && mat[0][j]=='O'){
                   //call dfs
                dfs(0,j,visited,mat,delrow,delcol);
            }
            //traverse last row
            if(visited[n-1][j]==0 &&mat[n-1][j]=='O' ){
                //call dfs
                dfs(n-1,j,visited,mat,delrow,delcol);
            }
        }

        //traverse first col and last col
        for(int i=0;i<n ;i++){
            // traverse first col
            if(visited[i][0]==0  && mat[i][0]=='O'){
                //call dfs
                dfs(i,0,visited,mat,delrow,delcol);
            }
            //traverse last col
            if(visited[i][m-1]==0 &&mat[i][m-1]=='O' ){
                //call dfs
                dfs(i,m-1,visited,mat,delrow,delcol);
            }
        }

        //traversing array again as whatever 0 left and is not marked , has to be X
        for(int i =0 ;i < n ;i++){
            for(int j=0;j < m;j++){
                if(visited[i][j]==0 && mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
       char[][] mat={{'X', 'X', 'X', 'X'},
                   {'O', 'X', 'X', 'X'},
                   {'X', 'O', 'O', 'X'},
                   {'X', 'O', 'X', 'X'},
                   {'X', 'X', 'O', 'O'}};

       char[][] output=fill(mat.length,mat[0].length,mat);
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
