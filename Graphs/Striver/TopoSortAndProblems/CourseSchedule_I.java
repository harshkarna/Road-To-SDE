/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
        Return true if you can finish all courses. Otherwise, return false.



        Example 1:

        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.
        Example 2:

        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

        */

package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_I {

    static boolean findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites)
    {
        //Create the graph aka adjacency list from given pre prerequisites list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i =0; i < n;i++){
            adj.add(new ArrayList<>());
        }
       // insert the connections in graph from the prerequisites array

        for(int i=0;i<m;i++){
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }


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

        if(topo.length==n){
            return true;
        }
        return false;


    }



    public static void main(String[] args) {


    }
}
