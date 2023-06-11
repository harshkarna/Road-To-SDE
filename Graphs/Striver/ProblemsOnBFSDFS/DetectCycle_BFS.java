/*Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

        Example 1:

        Input:
        V = 5, E = 5
        adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
        Output: 1
        Explanation:*/
package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle_BFS {

    private static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent ) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static  boolean detect(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[source]=true;
        Queue<Pair> pendingVertices=new LinkedList<>();
        pendingVertices.add(new Pair(source,-1));

        while(!pendingVertices.isEmpty()){
            int node = pendingVertices.peek().node;
            int parent=pendingVertices.peek().parent;
            pendingVertices.poll();

            for(int adjacentNode : adj.get(node)){
                if(!visited[adjacentNode]){
                    visited[adjacentNode]=true;
                    pendingVertices.add(new Pair(adjacentNode,node));
                }
                else if(parent!=adjacentNode){
                  return true;
                }

            }
        }
        return false;
    }


    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[]=new boolean[V];
       for(int i =0;i < V; i++){
           if(!visited[i]){
               if(detect(i,adj,visited)){
                   return true;
               }
           }
       }
       return false;
    }


    public static void main(String[] args) {
        int V=5;
        int E=5;
//        adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
//        System.out.println(isCycle(V,adj));


    }
}
