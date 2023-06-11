/*
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph


*/

package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*Approach  for Kahn's Algo

1. Topo sort is only valid or DAG (Directed Acyclic Graph)
2.As we are using BFS , so we are having queue
3.Here we will be using a indegree array , indegree means number of incoming edges to a node
4.So first step is fill up the indegree arr for every node.
5.insert all nodes with indegree 0 , in queue ( Need Proof - here there will be atleast one node whose
indegree will be zero in DAG).
6.take out now one by one from queue , and suppose a node A is picked , then place A in your final
ordering list and also to whatever A is connected to or we can its going to , remove those links
mean to say all those adjacent to A , decrease their indegree by 1 .
7 .Now check after decreasing that adjacent indegree , if their indegree is zero then , then place that adjacent node
in queue as we decided in step 5 .
8. As you are  polling nodes from queue and keep add them in your final ordering list
9.Keep repeating steps until queue is empty , oce empty you will be having your one of the  topo sort order



* */
public class KahnAlgo_TopSort_BFS {

    //Function to return list containing vertices in Topological order.
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
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

        //create an array to store linear ordering
        int[] topo=new int[V];
        int i=0;
        while(!pendingNodes.isEmpty()){
            int node=pendingNodes.poll();
            //add this node in final ordering array
            topo[i++]=node;

            //node is in your topo sort
            //so please remove it from indegree
            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;
                if(indegree[adjacentNode]==0){
                    pendingNodes.add(adjacentNode);
                }
            }
        }
        return topo;
    }


    public static void main(String[] args) {


    }
}
