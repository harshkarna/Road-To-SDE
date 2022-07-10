//Code: Rat In a Maze All Paths
//
//        You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow
//        to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
//        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not
//        enter into those cells and those with value 1 are open.
//        Input Format
//        The first line of input contains an integer 'N' representing
//        the dimension of the maze.
//        The next N lines of input contain N space-separated
//        integers representing the type of the cell.
//        Output Format :
//        For each test case, print the path from start position to destination position and
//        only cells that are part of the solution path should be 1, rest all cells should be 0.
//
//        Output for every test case will be printed in a separate line.
//        Note:
//        You do not need to print anything, it has already been taken care of. Just implement the given function.
//        Constraints:
//        0 < N < 11 0 <= Maze[i][j] <=1
//
//        Time Limit: 1sec
//        Sample Input 1 :
//        3
//        1 0 1
//        1 0 1
//        1 1 1
//        Sample Output 1 :
//        1 0 0 1 0 0 1 1 1
//        Sample Output 1 Explanation :
//        Only 1 path is possible
//
//        1 0 0
//        1 0 0
//        1 1 1
//        Which is printed from left to right and then top to bottom in one line.
//
//        Sample Input 2 :
//        3
//        1 0 1
//        1 1 1
//        1 1 1
//        Sample Output 2 :
//        1 0 0 1 1 1 1 1 1
//        1 0 0 1 0 0 1 1 1
//        1 0 0 1 1 0 0 1 1
//        1 0 0 1 1 1 0 0 1
//        Sample Output 2 Explanation :
//        4 paths are possible which are printed in the required format.

package com.Backtracking;

public class Rat_in_a_Maze_All_Paths {

    public static void ratInAMaze(int maze[][]){
        int n =maze.length;
        int path[][]=new int[n][n];
        printAllPaths(maze,0,0,path);

    }

    public static void printAllPaths(int maze[][],int i, int j, int path[][]){

        int n =maze.length;
        //To check if i , j cell is valid or not
        if(i<0 || i>=n || j< 0 || j>=n || maze[i][j] ==0 || path[i][j]==1 ){
            return ;
        }

        //Lets include the cell in current path
        path[i][j] =1;

        //Destination cell condition
        if(i==n-1 && j==n-1){
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    System.out.print(path[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j]=0;
            return;
        }

        //explore further in all direction
        //Top
        printAllPaths(maze,i-1,j,path);

        //Right
        printAllPaths(maze,i,j+1,path);

        //Down
        printAllPaths(maze,i+1,j,path);

        //Left
        printAllPaths(maze,i,j-1,path);
        path[i][j]=0;
    }

    public static void main(String[] args) {

        int maze[][]={{1,1,0},{1,1,0},{1,1,1}};
        ratInAMaze(maze);
//        boolean pathPossible =ratInAMaze(maze);
//        System.out.println(pathPossible);
    }
}
