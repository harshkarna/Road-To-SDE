package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;

public class ConnectedComponents_DFS {
    public static void dfsTravel(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean visited[]) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for (Integer i : adj.get(currentVertex)) {
            if (!visited[i]) {
                // i is the neighbor of the current vertex
                dfsTravel(adj, i, visited);
            }
        }
    }

    public static int countConnectedComponents(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        int connectedComponents = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTravel(adj, i, visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }
}
/*The time complexity of finding the number of connected components
using Depth-First Search (DFS) on an undirected graph with V vertices and E edges is O(V + E).*/