package com.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTravel {

/*
    Breadth-First Search(also known as Breadth-First Traversal) is a traversal mechanism that, as the name might suggest,
    traverses the graph in a breadthwise manner. This essentially means we start the search from a Node and then explore
    all of its neighbouring Vertices. Once these neighbouring vertices are explored, then we go ahead exploring all of
    their neighbouring vertices and so on.
*/

    public static void bfsTravel(int adjMatrix[][]){
        Queue<Integer> pendingVetices=new LinkedList<>();
        boolean visited[] =new boolean[adjMatrix.length];
        visited[0]=true;
        pendingVetices.add(0);

        while(!pendingVetices.isEmpty()){
            int currentVertex=pendingVetices.poll();
            System.out.print(currentVertex + " ");
            for(int i=0;i <adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i]==1 && visited[i]==false){
                    //i is unvisited neighbour of current vertex
                    pendingVetices.add(i);
                    visited[i]=true;
                }
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

        bfsTravel(adjMatrix);

    }
}
