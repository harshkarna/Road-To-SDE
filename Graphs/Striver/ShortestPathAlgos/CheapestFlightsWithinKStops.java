/*There are n cities and m edges connected by some number of flights. You are given an array flights where
 flights[i] = [fromi, toi, pricei] indicates that there is a flight from the city fromi to city toi with cost pricei.

        You are also given three integers src, dst, and k, return the cheapest price from src to dst with
         at most k stops. If there is no such route, return -1.

        Note: The price from city A to B may be different From price from city B to A.
        Example 1:
        Input:
        n = 4
        flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
        src = 0
        dst = 3
        k = 1
        Output:
        700
        Explanation:
        The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
        Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static class Pair{
        int node;
        int cost;
        public Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public static class tuple {
        int stops, node, cost;
        tuple(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public static int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.

        //we can use a simple  queue here also , as stops will increase by unit number
        PriorityQueue<tuple> q=new PriorityQueue<tuple>((x, y) -> x.stops - y.stops);


        q.add(new tuple(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            tuple it = q.peek();
            q.remove();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue;

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.node;
                int edW = iter.cost;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode]) {
                    dist[adjNode] = cost + edW;
                    q.add(new tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];


    }

    public static void main(String[] args) {


    }
}
