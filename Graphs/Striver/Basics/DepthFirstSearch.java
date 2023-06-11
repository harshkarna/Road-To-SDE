package com.Graphs.Striver.Basics;

import java.util.ArrayList;

public class DepthFirstSearch {

    // Add edge
    static void addEdge(ArrayList<ArrayList<Integer>> am, int s, int d) {
        am.get(s).add(d);
        am.get(d).add(s);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> am) {
        for (int i = 0; i < am.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < am.get(i).size(); j++) {
                System.out.print(" -> " + am.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void dfsTravel(ArrayList<ArrayList<Integer>> adj,int currentVertex,boolean visited[]){
        visited[currentVertex]=true;
        System.out.print (currentVertex +" ");
        for(Integer i : adj.get(currentVertex)){
            if( !visited[i] ){
                // i is the neighbour of current vertex
                dfsTravel(adj,i,visited);
            }
        }
    }

    public static void dfsTravel(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] =new boolean[adj.size()];
        dfsTravel(adj,0, visited);

    }


    public static void main(String[] args) {
        // Create the graph
        int V = 5;
        ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            am.add(new ArrayList<Integer>());

        // Add edges
        addEdge(am, 0, 1);
        addEdge(am, 0, 2);
        addEdge(am, 0, 3);
        addEdge(am, 1, 2);
        addEdge(am, 1, 4);


        printGraph(am);

        dfsTravel(V,am);

    }
}
