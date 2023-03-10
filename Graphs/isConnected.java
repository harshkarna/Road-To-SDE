/*
isConnected?

        Given an undirected graph G(V,E), check if the graph G is connected graph or not.
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
        Output Format :
        The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
        Constraints :
        0 <= V <= 1000
        0 <= E <= (V * (V - 1)) / 2
        0 <= a <= V - 1
        0 <= b <= V - 1
        Time Limit: 1 second
        Sample Input 1:
        4 4
        0 1
        0 3
        1 2
        2 3
        Sample Output 1:
        true
        Sample Input 2:
        4 3
        0 1
        1 3
        0 3
        Sample Output 2:
        false
        Sample Output 2 Explanation
        The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2.
        package com.Graphs;
*/
package com.Graphs;

import java.util.Scanner;

public class isConnected {

    public static void dfsTravel(int adjMatrix[][],int currentVertex,boolean visited[]){
        visited[currentVertex]=true;
        for(int i=0;i < adjMatrix.length;i++){
            if(adjMatrix[currentVertex][i]==1 && visited[i]==false){
                // i is the neighbour of current vertex
                dfsTravel(adjMatrix,i,visited);
            }
        }
    }


    public static boolean isConnected(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        dfsTravel(adjMatrix, 0, visited);
        for(int i = 0; i <visited.length; i++){
            if (!visited[i]) {
                return false;
            }
        }
        return true;
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

        System.out.println(isConnected(adjMatrix));

    }
}
