package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CouseSchedule_LC {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n =numCourses;
        //Create the graph aka adjacency list from given pre prerequisites list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i =0; i < n;i++){
            adj.add(new ArrayList<>());
        }
        // insert the connections in graph from the prerequisites array
        // for(int i=0; i < prerequisites.length ;i++){
        //     adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        // }

        for(int i=0;i<prerequisites.length;i++)adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        //create the in degree array
        int[] indegree=new int[n];
        //fill up the  indegree array
        for(int i =0; i < n ;i++){
            for(int adjacentNode : adj.get(i)){
                indegree[adjacentNode]++;
            }
        }

        //Now traverse over the array and push the nodes in queue whose indegree is zero
        Queue<Integer> pendingNodes=new LinkedList<>();
        for(int i =0 ; i < n ;i++){
            if(indegree[i]==0){
                pendingNodes.add(i);
            }
        }

        //Someone will obviously will be having indegree as 0 as its DAG graph --doubt

        //create an array to store linear ordering
        int[] topo=new int[n];
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

        if(topo.length==n){ //means  cycle  no cycle
            return topo;
        }
        return new int[]{};//means  cycle  no cycle

    }

    public static void main(String[] args) {

        int[][] prerequisites ={{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites ={{1,0},{0,1}};
        int n=4;
        int[] ans=findOrder(n, prerequisites);
        for(int i : ans){
            System.out.println(i + " ");
        }



    }
}
