/*There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi , toi ,weighti]
 represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distance Threshold.
 You need to find out a city with the smallest number of cities that are reachable through some path and
 whose distance is at most Threshold Distance, If there are multiple such cities, our answer will be the city with the greatest number.

        Note: that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

        Example 1:

        Input:
        N=4,M=4
        edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
        distanceThreshold = 4
        Output:3
        Explaination:

        The neighboring cities at a distanceThreshold = 4 for each city are:
        City 0 -> [City 1, City 2]
        City 1 -> [City 0, City 2, City 3]
        City 2 -> [City 0, City 1, City 3]
        City 3 -> [City 1, City 2]
        Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number

        .*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CitySmallestNumberNeighboursThresholdDistance_Djikstra {

    public static class Pair{
        int node;
        int distance;
        public Pair(int distance,int node){
            this.distance = distance;
            this.node = node;

        }
    }

    public  static void dijkstra(int src, int[] dis, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b)-> a.distance - b.distance);
        pq.add(new Pair(0, src));
        dis[src] = 0;

        while(!pq.isEmpty()) {
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for(Pair it : adj.get(node)) {
                int adjNode = it.node;
                int edW = it.distance;

                if (dist + edW <= dis[adjNode]) {
                    dis[adjNode] = dist + edW;
                    pq.add(new Pair(dist + edW, adjNode));
                }

            }

        }
    }

    public static int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        int[][] dis= new int[n][n];

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dis[i][j] = (int) 1e9;
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];

            adj.get(from).add(new Pair(wt, to));
            adj.get(to).add(new Pair(wt, from));
            //below not req but still, as we are trying to mimic djiktra and we usually send infinite dist array
            dis[from][to] = wt;
            dis[to][from] = wt;
        }

        //mark themselves one as zero
        for (int i = 0; i < n; i++) dis[i][i] = 0;


        for(int i = 0; i < n; i++) {
             dijkstra(i, dis[i], adj);
        }


        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dis[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
//        int[][] edges={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int[][] edges={{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int threshold=2;
        System.out.println(findCity(5,6,edges,threshold));

    }
}
