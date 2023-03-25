package com.Graphs;

import java.util.Scanner;

public class dfs_for_diconnectedGraph {

    public static void dfsTravel(int adjMatrix[][],int currentVertex,boolean visited[]){
        visited[currentVertex]=true;
        System.out.print(currentVertex +" ");
        for(int i=0;i < adjMatrix.length;i++){
            if(adjMatrix[currentVertex][i]==1 && visited[i]==false){
                // i is the neighbour of current vertex
                dfsTravel(adjMatrix,i,visited);
            }
        }
    }
    public static void dfsTravel(int adjMatrix[][]){
        boolean visited[] =new boolean[adjMatrix.length];
        for(int i=0;i<adjMatrix.length;i++){
            if(!visited[i]){
                dfsTravel(adjMatrix,i, visited);
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter no of vertices");
        int n=sc.nextInt(); //no of vertices
        System.out.println(" Enter no of edges");
        int e=sc.nextInt(); // no of edges

        int adjMatrix[][]=new int[n][n]; //creating n by n matrix

        for(int i=0;i < e ;i++){
            //here we are giving  edges between vertices and then filling 2d array both way
//            System.out.println("Enter the first vertex of current edge");
            int v1=sc.nextInt();
//            System.out.println("Enter the second vertex of current edge");
            int v2=sc.nextInt();
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1;
        }

        dfsTravel(adjMatrix);


    }
}