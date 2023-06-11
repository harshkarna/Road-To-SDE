/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is
connected directly with city c, then city a is connected indirectly with city c.

        A province is a group of directly or indirectly connected cities and no other cities outside of the group.

        You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
        and isConnected[i][j] = 0 otherwise.

        Return the total number of provinces.*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

import java.util.ArrayList;

public class NumberOfProvinceMatrix_GFG {

        public static void dfs(ArrayList<ArrayList<Integer>> isConnected , int currentVertex, boolean[] visited){
            visited[currentVertex]=true;
            for(Integer i : isConnected.get(currentVertex)){
                if( !visited[i]){
                    // i is the neighbour of current vertex
                    dfs(isConnected,i,visited);
                }
            }
        }


        static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

            //as we are given adj matrix so converting it first to adj list
            ArrayList<ArrayList<Integer>> adjL = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++){
                adjL.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(adj.get(i).get(j) == 1 && i != j){
                        adjL.get(i).add(j);
                        adjL.get(j).add(i);
                    }
                }
            }

            boolean[] visited=new boolean[V];
            int count=0;
            for(int i=0; i < V ;i++){
                if(!visited[i]){
                    dfs(adjL,i,visited);
                    count++;
                }
            }
            return count;
        }
    };

