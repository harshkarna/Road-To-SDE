/*
Has Path?

        Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers),
        check if there exists any path between them or not. Print true if the path exists and false otherwise.
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
        The following line contain two integers, that denote the value of v1 and v2.
        Output Format :
        The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
        Constraints :
        0 <= V <= 1000
        0 <= E <= 1000
        0 <= a <= V - 1
        0 <= b <= V - 1
        0 <= v1 <= 2^31 - 1
        0 <= v2 <= 2^31 - 1
        Time Limit: 1 second
        Sample Input 1 :
        4 4
        0 1
        0 3
        1 2
        2 3
        1 3
        Sample Output 1 :
        true
        Sample Input 2 :
        6 3
        5 3
        0 1
        3 4
        0 3
        Sample Output 2 :
        false
*/

package com.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hasPath {

    public static boolean bfsTravel(int adjMatrix[][],int sv, int ev) {
        // check for invalid input for sv or ev
        if( sv > (adjMatrix.length) || ev > (adjMatrix.length)){
            return false;
        }
        //to check if there is a direct edge between
        if(adjMatrix[sv][ev]==1){
            return true;
        }
        Queue<Integer> pendingVetices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[sv] = true;
        pendingVetices.add(sv);

        while (!pendingVetices.isEmpty()) {
            int currentVertex = pendingVetices.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
                    if(i==ev){
                        return true;
                    }
                    else{
                        //i is unvisited neighbour of current vertex
                        pendingVetices.add(i);
                        visited[i] = true;
                    }

                }
            }
        }
        return false;
    }

    public static  boolean hasPath(int[][] adjMatrix, int sv, int ev){
        return bfsTravel(adjMatrix,sv,ev);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter no of vertices");
        int n = sc.nextInt(); //no of vertices
        System.out.println(" Enter no of edges");
        int e = sc.nextInt(); // no of edges

        int adjMatrix[][] = new int[n][n]; //creating n by n matrix

        for (int i = 0; i < e; i++) {
            //here we are giving  edges between vertices and then filling 2d array both way
//            System.out.println("Enter the first vertex of current edge");
            int v1 = sc.nextInt();
//            System.out.println("Enter the second vertex of current edge");
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        int sv=1;
        int ev=3;

        System.out.println(hasPath(adjMatrix, sv, ev));

    }
}
