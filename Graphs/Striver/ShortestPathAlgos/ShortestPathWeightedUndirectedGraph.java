//You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges
//        describing there are edges between a to b with some weight, find the shortest path between
//        the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.
//
//        Example:
//        Input:
//        n = 5, m= 6
//        edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
//        Output:
//        1 4 3 5
//        Explaination:
//        Shortest path from 1 to n is by the path 1 4 3 5


package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathWeightedUndirectedGraph {

    private static class Pair {
        int first; //node
        int second; //distance

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        //create the graph
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i =0; i <=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i < m ;i++){
            //as its a undirected graph , create both sides edges with weights
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        //apply the djikstra algo
        PriorityQueue <Pair> pq=new PriorityQueue<Pair>((x, y) -> x.second - y.second);
        //create distnace and parent array to know where a node came from
        int distance[]=new int[n+1];
        int parent[]=new int[n+1];
        for(int i =1; i <=n ;i++){
            distance[i]=(int)(1e9);
            parent[i]=i;
        }

        //mark source distance 0 and add source node in min heap queue
        distance[1]=0;
        pq.add(new Pair(0,1));

        while(!pq.isEmpty()){
            int node = pq.peek().second;
            int dist=pq.peek().first;
            pq.poll();


            for(Pair iter: adj.get(node)){
                int adjNode=iter.first;
                int edgeWeight=iter.second;
                if(dist +edgeWeight  < distance[adjNode]) {
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new Pair(dist + edgeWeight, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        //in case we are not able to reach destination
        List<Integer> path=new ArrayList<>();
        if(distance[n]==1e9){
            path.add(-1);
            return path;
        }

        int node = n ;
        //0(N)
        while(parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;

    }


    public static void main(String[] args) {



    }
}
