//Code: Rat In A Maze
//
//        You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to
//        reach its destination i.e. maze[N-1][N-1]. Rat can move in any direction ( left, right, up and down).
//        Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can not
//        enter into those cells and those with value 1 are open.
//        Input Format
//        Line 1: Integer N
//        Next N Lines: Each line will contain ith row elements (separated by space)
//        Output Format :
//        The output line contains true if any path exists for the rat to reach its destination otherwise print false.
//        Sample Input 1 :
//        3
//        1 0 1
//        1 0 1
//        1 1 1
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        3
//        1 0 1
//        1 0 1
//        0 1 1
//        Sample Output 2 :
//        false

package com.Backtracking;

public class Rat_in_a_Maze {


    public static boolean ratInAMaze(int maze[][]){
        int n =maze.length;
        int path[][]=new int[n][n];
        return solveMaze(maze,0,0,path);

    }

    public static boolean solveMaze(int maze[][],int i, int j, int path[][]){

        int n =maze.length;
        //To check if i , j cell is valid or not
        if(i<0 || i>=n || j< 0 || j>=n || maze[i][j] ==0 || path[i][j]==1 ){
            return false;
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
            return true;
        }

        //explore further in all direction
        //Top
        if(solveMaze(maze,i-1,j,path)){
            return true;
        }
        //Right
        if(solveMaze(maze,i,j+1,path)){
            return true;
        }
        //Down
        if(solveMaze(maze,i+1,j,path)){
            return true;
        }
        //Left
        if(solveMaze(maze,i,j-1,path)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int maze[][]={{1,1,0},{1,1,0},{1,1,1}};
        boolean pathPossible =ratInAMaze(maze);
        System.out.println(pathPossible);
    }
}
