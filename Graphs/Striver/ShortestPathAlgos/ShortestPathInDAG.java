/*
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i

        Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.



        Example:

        Input:
        n = 6, m= 7
        edge=[[0,1,2],[0,4,1],[4,5,4]
        ,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

        Output:
        0 2 3 6 1 5
*/

package com.Graphs.Striver.ShortestPathAlgos;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDAG {

    private static class Pair {
        int first; //node
        int second; //distance

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    private static void topoSort(int node, int[] visited, Stack<Integer> stack,ArrayList<ArrayList<Pair>> adj ) {
        visited[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int adjacentNode = adj.get(node).get(i).first;
            if (visited[adjacentNode] == 0) {
                //when the node is not visited
                topoSort(adjacentNode, visited, stack, adj);
            }
        }
        //at the end when you dont have any call to made , store in stack
        stack.push(node);
    }


    public static int[] shortestPath(int N,int M, int[][] edges) {
//create a graph
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i =0; i < N;i++){
            ArrayList<Pair> temp=new ArrayList<Pair>();
            adj.add(temp);
        }

        for(int i=0 ;i < M ; i++){
            int u =edges[i][0];
            int v =edges[i][1];
            int wt =edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        //find the topo sort
        int vis[] =new int[N];
        Stack<Integer> stack =new Stack<>();
        for(int i =0; i < N ; i++){
            if(vis[i]==0){
                topoSort(i , vis , stack , adj);
            }
        }

        // Step 2 do the distance thing
        int distance[]=new int[N];
        for(int i =0 ; i < N ; i++){
            distance[i]=Integer.MAX_VALUE;
//            distance[i]=(int) 1e9;
        }
        //mark the source node 0 in dist array
        distance[0]=0;

        while(!stack.isEmpty()){
            int node=stack.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (distance[node] + wt < distance[v]) {
                    distance[v] = wt + distance[node];
                }
            }
        }


        for (int i = 0; i < N; i++) {
            //Integer.MAX_VALUE not working becoause it will overflow
//            if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
            if (distance[i] == (int) 1e9) distance[i] = -1;

        }
        return distance;

    }

    public static void main(String[] args) {
        int N=5;
        int M=5;
        int[][] edges={{0,1,2},{2,1,2},{2,4,2},{1,4,8},{1,3,6}};
        int[] res=shortestPath(N,M,edges);
        for(int i : res){
            System.out.print(i +" ");
        }

    }
}
