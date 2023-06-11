package com.Graphs.Striver.Basics;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatriixToList {


    public static void adjMatrixToList(int[][] adjMatrix){
        int n = adjMatrix.length;
        ArrayList<ArrayList<Integer>> adjL=new ArrayList<>();
        for(int i =0; i < n;i++){
            //here we are giving  edges between vertices and then filling 2d array both way
            adjL.add(new ArrayList<Integer>());
        }

        for(int i =0; i < n ;i++){
            for(int j=0; j < n ;j++){
                if(adjMatrix[i][j]==1 && i!=j){
                    adjL.get(i).add(j);
//                    adjL.get(j).add(i);
                }
            }
        }

        //print the Adj list
        for(int i=0; i < n ;i++){
            System.out.print(i + " : ->");

            for(int j = 0;j < adjL.get(i).size() ;j++){
                System.out.print(adjL.get(i).get(j)+ " ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //no of vertices
        int e=sc.nextInt(); // no of edges

        int adjMatrix[][]=new int[n][n]; //creating n by n matrix

        for(int i=0;i < e ;i++){
            //here we are giving  edges between vertices and then filling 2d array both way
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1;
        }


        //printing the array
        for(int i=0;i<n;i++){
            for(int j=0;j<n ;j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*******************");

        adjMatrixToList(adjMatrix);


    }
}
