package com.Graphs.Striver.MST_DisjointSets;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;

        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    public static int spanningTree(int V, int E, int edges[][]){
        // Create adjacency list to represent the directed graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the adjacency list from the given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];
        pq.add(new Pair(0, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            //if that node is already touched , move forward
            if (vis[node] == 1) continue;
            //if a new node unvisited
            // add it to the mst weight and mark visited
            vis[node] = 1;
            sum += wt;

            //now check for the adjacent nodes
            for(Pair iter: adj.get(node)){
                int adjNode=iter.node;
                int edgeWeight=iter.distance;
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode,edgeWeight));
                }
            }
        }
        return sum;
    }



    public static void main(String[] args) {


    }
}
