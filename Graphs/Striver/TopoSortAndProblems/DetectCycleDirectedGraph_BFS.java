package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph_BFS {
    //Function to return list containing vertices in Topological order.
    public static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //create the in degree array
        int[] indegree=new int[V];
        //fill up the  indegree array
        for(int i =0; i <V ;i++){
            for(int adjacentNode : adj.get(i)){
                indegree[adjacentNode]++;
            }
        }

        //Now traverse over the array and push the nodes in queue whose indegree is zero
        Queue<Integer> pendingNodes=new LinkedList<>();
        for(int i =0 ; i < V ;i++){
            if(indegree[i]==0){
                pendingNodes.add(i);
            }
        }

        //Someone will obviously will be having indegree as 0 as its DAG graph --doubt

        //have  a count variable
        int count=0;
        while(!pendingNodes.isEmpty()){
            int node=pendingNodes.poll();
            //add this node in final ordering array
            count++;

            //node is in your topo sort
            //so please remove it from indegree
            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;
                if(indegree[adjacentNode]==0){
                    pendingNodes.add(adjacentNode);
                }
            }
        }

        if(count==V){
            //means topo sort successfully executed , hence no cycle detected
           return false;
        }
        return true ;

    }

    public static void main(String[] args) {


    }


}
