package com.Graphs.Striver;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphAdjancyList {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //no of vertices
        int e=sc.nextInt(); // no of edges

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i =0; i < n;i++){
            //here we are giving  edges between vertices and then filling 2d array both way
            adj.add(new ArrayList<Integer>());
        }
        //     int v1=sc.nextInt();
//            int v2=sc.nextInt();
//            adj.get(v1).add(v2);
//            adj.get(v2).add(v1);
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);


        for(int i=0; i < n ;i++){
            for(int j = 0;j < adj.get(i).size() ;j++){
                System.out.print(adj.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
