/*You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional
 roads between some intersections. The inputs are generated such that you can reach any intersection
  from any other intersection and that there is at most one road between any two intersections.
        You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means
        that there is a road between intersections ui and vi that takes timei minutes to travel. You want
        to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest
        amount of time.

        Return the number of ways you can arrive at your destination in the shortest amount of time.
        Since the answer may be large, return it modulo 109 + 7.

        Example 1:

        Input:
        n=7, m=10
        edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

        Output:
        4
        Explaination:

        The four ways to get there in 7 minutes are:
        - 0  6
        - 0  4  6
        - 0  1  2  5  6
        - 0  1  3  5  6*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    public static class Pair{
        int node;
        int distance;
        public Pair(int distance,int node){
            this.distance = distance;
            this.node = node;
        }
    }

    static int countPaths(int n, ArrayList<ArrayList<Integer>> roads) {

        // Creating an adjacency list for the given graph.
        ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<> ());
        }
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(2), roads.get(i).get(1)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(2), roads.get(i).get(0)));
        }

        // Defining a priority queue (min heap).
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edW = it.distance;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                // If we again encounter a node with the same short distance
                // as before, we simply increment the no. of ways.
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the no. of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;

    }

    public static void main(String[] args) {


    }
}
