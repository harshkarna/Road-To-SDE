package com.Graphs.Striver.TopoSortAndProblems;

import java.util.*;

public class FindEventualSafeStates_BFS {

    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        //doubt --why reverse edges

        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int adjacentNodes : adj.get(i)) {
                adjRev.get(adjacentNodes).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> pendingNodes = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                pendingNodes.add(i);
            }
        }

        while (!pendingNodes.isEmpty()) {
            int node = pendingNodes.poll();
            safeNodes.add(node);


            for (int adjacentNodes : adjRev.get(node)) {
                indegree[adjacentNodes]--;
                if (indegree[adjacentNodes] == 0) {
                    pendingNodes.add(adjacentNodes);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }


    public static void main(String[] args) {


    }
}
