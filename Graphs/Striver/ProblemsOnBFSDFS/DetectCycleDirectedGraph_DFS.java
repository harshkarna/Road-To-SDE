/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,

check whether it contains any cycle or not.
*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;

public class DetectCycleDirectedGraph_DFS {



    /*
    Things to be note
    We can eliminate the check array and just use if(pathVis[i] == 0) to get the safe nodes
    and use the absolute same code as cycle detection in directed graph, just add this in end:
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<V; i++) {
            if(!path[i])
                res.add(i);
        }
    *
    * */

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] currentPathVisited) {
      visited[node]=1;
      currentPathVisited[node]=1;
      //traverse for adjacent nodes
        for(int adjacentNode : adj.get(node)){
            if(visited[adjacentNode]==0){
                //when the node is not visited
                if(dfsCheck(adjacentNode,adj,visited, currentPathVisited)){
                    return true;
                }
            }
            // if the node has been previously visited
            //but it has to be visited on the same path
            else if (currentPathVisited[adjacentNode]==1){
                return true;
            }
        }

      //while returning back , make current node unvisited in path visited
        currentPathVisited[node]=0;
        return false;

    }


    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        //create  the visited array and path vist
        int[] visited=new int[V];
        int[] currentPathVisited=new int[V];

        //handling multiple components cases
        for(int i =0;i < V; i++){
            if(visited[i]==0){
                if(dfsCheck(i,adj,visited, currentPathVisited)){
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {


    }
}
