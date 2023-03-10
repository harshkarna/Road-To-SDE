package com.Graphs;

import java.util.Scanner;

public class GraphAdjancymatrix {

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

    }
}
