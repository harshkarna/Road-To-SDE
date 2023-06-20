/*You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel
times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and
wi is the time it takes for a signal to travel from source to target.

        We will send a signal from a given node k. Return the minimum time it takes for all the n nodes
        to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.


        Example 1:

        Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        Output: 2*/
package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;

import java.util.PriorityQueue;

public class Network_Delay_Time {
    public static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list to represent the directed graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build the adjacency list from the given edges
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
        }

        // Create a min heap (priority queue) to store pair of distance and node
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        // Initialize the distance array with infinity values except for the source vertex
        int[] dist = new int[n+1];
        for (int i = 1; i <=n; i++) dist[i] = (int) 1e9;
        //keep source as 0 in dist array, here my source will be k
        dist[k] = 0;

        // Add the source vertex to the priority queue
        pq.add(new Pair(k, 0));

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

        // return -1 if signal is not reachable
        for (int i = 1; i <=n; i++) {
            if (dist[i] == (int) 1e9) {
                return -1;
            }
        }


        //now search for the max dist we have , and it will be the answer
        int max =Integer.MIN_VALUE;
        for (int i = 1; i <=n; i++) {
            if(dist[i]> max){
                max=dist[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));


    }
}
