/*Given a weighted, undirected and connected graph of V vertices and an adjacency
list adj where adj[i] is a list of lists containing two integers where the first integer
of each list j denotes there is edge between i and j , second integers corresponds to the
 weight of that  edge . You are given the source vertex S and You to Find the shortest
  distance of all the vertex's from the source vertex S. You have to return a list of
  integers denoting shortest
distance between each node and Source vertex S.

        Note: The Graph doesn't contain any negative weight cycle.

        Example 1:

        Input:
        V = 2
        adj [] = {{{1, 9}}, {{0, 9}}}
        S = 0
        Output:
        0 9
        Explanation:

        The source vertex is 0. Hence, the shortest
        distance of node 0 is 0 and the shortest
        distance from node 1 is 9.


        Example 2:

        Input:
        V = 3, E = 3
        adj = { {{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
        S = 2
        Output:
        4 3 0
        Explanation:

        For nodes 2 to 0, we can follow the path-
        2-1-0. This has a distance of 1+3 = 4,
        whereas the path 2-0 has a distance of 6. So,
        the Shortest path from 2 to 0 is 4.
        The shortest distance from 0 to 1 is 1 .*/
package com.Graphs.Striver.ShortestPathAlgos;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgoPQ {

    public static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;

        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        //create min heap which holds pair of distance and node
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        //now create the distance array and fill with infinite value
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int) 1e9;

        //now set the initial config
        //set source as 0 in dist array and push it i n queue
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int distanceNode = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for (ArrayList<Integer> al : adj.get(node)) {
                int edgeWeight = al.get(1);
                int adjNode = al.get(0);
                if (distanceNode + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distanceNode + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }

            }

        }

        return dist;
    }

    public static void main(String[] args) {

    }

}
