/*
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and
 a 2D Integer array(or vector) edges[ ][ ] of length M, where
  there is a directed edge from edge[i][0] to edge[i][1] with
  a distance of edge[i][2] for all i, 0<=i

        Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

        Example:

        Input:
        n = 6, m= 7
        edge=[[0,1,2],[0,4,1],[4,5,4]
        ,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

        Output:
        0 2 3 6 1 5
*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;


//why cant we apply djikstra algo here


public class ShortestPathInDAG_Djiktra {

    public static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int[] dijkstra(int N, int[][] edges, int src) {
        // Create adjacency list to represent the directed graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list from the given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
        }

        // Create a min heap (priority queue) to store pair of distance and node
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        // Initialize the distance array with infinity values except for the source vertex
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Add the source vertex to the priority queue
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.poll().node;

            // Iterate through the adjacent vertices
            for (Pair edge : adj.get(node)) {
                int adjNode = edge.node;
                int edgeWeight = edge.distance;

                // Calculate the new tentative distance
                int newDistance = dist[node] + edgeWeight;

                // If the new distance is smaller, update the distance array and enqueue the adjacent vertex
                if (newDistance < dist[adjNode]) {
                    dist[adjNode] = newDistance;
                    pq.add(new Pair(adjNode, newDistance));
                }
            }
        }

        // Set unreachable vertices to -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int N = 5;
        int M = 5;
        int[][] edges = {{0, 1, 2}, {2, 1, 2}, {2, 4, 2}, {1, 4, 8}, {1, 3, 6}};
//        int[] res=dijkstra(N,M,edges);
//        for(int i : res){
//            System.out.print(i +" ");
    }

}

