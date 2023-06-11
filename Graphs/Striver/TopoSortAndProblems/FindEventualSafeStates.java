/*There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented
 by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 meaning there is an edge from node i to each node in graph[i].

        A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible
        path starting from that node leads to a terminal node (or another safe node).

        Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
        Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        Output: [2,4,5,6]
        Explanation: The given graph is shown above.
        Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
        Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
*/
package com.Graphs.Striver.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited, int[] currentPathVisited, int[] check ) {
        visited[node]=1;
        currentPathVisited[node]=1;
        //traverse for adjacent nodes
        for(int adjacentNode : adj.get(node)){
            if(visited[adjacentNode]==0){
                //when the node is not visited
                if(dfsCheck(adjacentNode,adj,visited, currentPathVisited, check)){
                    check[node]=0;
                    return true;
                }
            }
            // if the node has been previously visited
            //but it has to be visited on the same path
            else if (currentPathVisited[adjacentNode]==1){
                check[node]=0;
                return true;
            }
        }
        //if code reaches here means that nodes is safe
        check[node]=1;

        //while returning back , make current node unvisited in path visited
        currentPathVisited[node]=0;
        return false;

    }

   public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
       //create  the visited array and path vist
       int[] visited=new int[V];
       int[] currentPathVisited=new int[V];

       //we need one check for nodes which are safe
       int[] check_if_safe=new int[V];

       //store in an ans list
       List<Integer> ans=new ArrayList<>();

       //handling multiple components cases
       for(int i =0;i < V; i++){
           if(visited[i]==0) {
               dfsCheck(i, adj, visited, currentPathVisited,check_if_safe);
           }
       }
       //put all the safe nodes in ans list
       for(int i=0; i< V;i++){
           if(check_if_safe[i]==1) ans.add(i);
       }
       return ans;

    }

    public static void main(String[] args) {


    }
}
