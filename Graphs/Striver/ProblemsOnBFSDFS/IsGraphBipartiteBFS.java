/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

        There are no self-edges (graph[u] does not contain u).
        There are no parallel edges (graph[u] does not contain duplicate values).
        If v is in graph[u], then u is in graph[v] (the graph is undirected).
        The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
        A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

        Return true if and only if it is bipartite.



        In short -  if you colour every adjacent nodes of a graph with diff colour  , then there should not be any adjacent nodes
        with same color .Remember , linear graph and graph having cycles with even length are always Bipartite
        .But  graph having cycles with odd length are not Bipartite

*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {

    //colors a component
    public boolean checkIsBipartite(int start,int V ,ArrayList<ArrayList<Integer>>adj , int[] colour){
        Queue<Integer> pendingNodes=new LinkedList<>();
        pendingNodes.add(start);
        colour[start]=0;

        while(!pendingNodes.isEmpty()){
            int currentNode=pendingNodes.poll();

            for(int adjacentNode : adj.get(currentNode)){
                //if the adjacent node is yet not colored
                //you will give the opposite color of the node
                if(colour[adjacentNode]==-1){
                    colour[adjacentNode]=1- colour[currentNode];
                    pendingNodes.add(adjacentNode);

                }
                //check if the adjacent guy having the same colour
                //someone did colour it on some other path
                else if (colour[adjacentNode]==colour[currentNode]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] colour=new int[V];
        for(int i =0;i < V;i++) colour[i]=-1;

        //handling multiple components cases
        for(int i =0;i < V; i++){
            if(colour[i] == -1){
                if(checkIsBipartite(i,V,adj,colour) == false ){
                    return false;
                }
            }
        }
        return true;


    }

    public static void main(String[] args) {


    }
}
