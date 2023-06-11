/*
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
*/

package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_DFS {

    private static void dfs(int node, int[] visited, Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj ) {
        visited[node] = 1;
        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                //when the node is not visited
                dfs(adjacentNode, visited, stack, adj);
            }
        }
        //at the end when you dont have any call to made , store in stack
        stack.push(node);
    }


    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
       //create the visited array
        int[] visited=new int[V];
        //create the stack to store the ordering
        Stack<Integer> stack=new Stack<>();
        //handling multiple components cases
        for(int i =0;i < V; i++){
            if(visited[i]==0) {
                dfs(i ,visited, stack, adj );
            }
        }
        int[] ans =new int[V];
        int i=0;
        while(!stack.isEmpty()){
            ans[i]=stack.peek();
            stack.pop();
            i++;
        }
        return ans ;
    }


    public static void main(String[] args) {


    }
}
