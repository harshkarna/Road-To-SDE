package com.Graphs.Striver.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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
            System.out.println( );
        }
    }

    public static void bfsTravel(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> pendingVetices=new LinkedList<>();
        boolean visited[] =new boolean[adj.size()];

        pendingVetices.add(0);
        visited[0]=true;

        while(!pendingVetices.isEmpty()){
            Integer currentVertex=pendingVetices.poll();
            System.out.print(currentVertex + " ");

            //while ho to each neighbour of currentVertex in loop
            //and check if its visited or not
            for(Integer i: adj.get(currentVertex)){
                if( !visited[i]){
                    visited[i]=true;
                    pendingVetices.add(i);
                }
            }
        }
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

        bfsTravel(am);

    }
}
