/*You are given an Undirected Graph having unit weight,
Find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

        Example:

        Input:
        n = 9, m= 10
        edges=[[0,1],[0,3],[3,4],[4 ,5]
        ,[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]]
        src=0
        Output:
        0 1 2 1 2 3 3 4 4

        */
package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

    public  static int[] shortestPath(int[][] edges,int n,int m ,int src) {
       //create the graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i =0; i < n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i < m ;i++){
            //as it's  undirected graph , create both sides edges
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        

        //now create the distance array and fill with infinite value
        int dist[]=new int[n];
        for(int i =0; i< n; i++) dist[i]=(int) 1e9;

        //mark source 0 in dist array
        dist[src]=0;

        //create the queue for bfs travel
        Queue<Integer> pendingVertices= new LinkedList<>();
        pendingVertices.add(src);

        //now lets travel in graph
        while(!pendingVertices.isEmpty()){
            int currentNode =pendingVertices.poll();
            for(int adjacentNode : adj.get(currentNode)){
                //if the current  dist of  adjacent node from source is greater
                //than what's coming from current node +1 , then update adj nde distance
                //with the shorter one
                if(dist[currentNode] + 1 < dist[adjacentNode]){
                    dist[adjacentNode]=dist[currentNode] + 1;
                    pendingVertices.add(adjacentNode);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            //Integer.MAX_VALUE not working becoause it will overflow
//            if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
            if (dist[i] == (int) 1e9) dist[i] = -1;

        }
        return dist;

    }


    public static void main(String[] args) {


    }
}
