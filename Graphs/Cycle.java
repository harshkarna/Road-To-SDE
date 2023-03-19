/*
Cycle

        Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges,
        then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
        Input Format :
        The first line of input contains two space separated integers, that denotes the value of N and M.
        Each of the following M lines contain two integers, that denote the vertices which have
        an undirected edge between them. Let us denote the two vertices with the symbol u and v.
        Output Format :
        Print the count the number of 3-cycles in the given graph
        Constraints :
        0 <= N <= 100
        0 <= M <= (N*(N-1))/2
        0 <= u <= N - 1
        0 <= v <= N - 1
        Time Limit: 1 sec
        Sample Input 1:
        3 3
        0 1
        1 2
        2 0
        Sample Output 1:
        1
        */
package com.Graphs;

import java.util.Scanner;


public class Cycle {

    public static int countCycle(int[][] adjMatrix ,int n ){
        int cycleCount=0;
        for(int i=0;i< n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if (adjMatrix[i][j]==1 && adjMatrix[j][k]==1 && adjMatrix[k][i]==1) {
                        cycleCount++;
                    }
                }
            }
        }
        return cycleCount;
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
        int ans=countCycle(adjMatrix, adjMatrix.length);
        System.out.println(ans);

    }
}
