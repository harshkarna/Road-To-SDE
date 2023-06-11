package com.Graphs.Striver.ProblemsOnBFSDFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteDFS {

    public boolean checkIsBipartiteDFS(int currentNode ,int col ,ArrayList<ArrayList<Integer>>adj ,int[] colour){
        colour[currentNode]=col;
        for(int adjacentNode : adj.get(currentNode)){
            //if the adjacent node is yet not colored
            //you will give the opposite color of the node
            if(colour[adjacentNode]==-1){
                if(checkIsBipartiteDFS(adjacentNode,1- col,adj,colour)==false) return false;
            }
            //check if the adjacent guy having the same colour
            //someone did colour it on some other path
            else if (colour[adjacentNode]==colour[currentNode]){
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite( int V , ArrayList<ArrayList<Integer>>adj){
        int[] colour=new int[V];
        for(int i =0;i < V;i++) colour[i]=-1;

        //handling multiple components cases
        for(int i =0;i < V; i++){
            if(colour[i] == -1){
                if(checkIsBipartiteDFS(i,0,adj,colour) == false ){
                    return false;
                }
            }
        }
        return true;
    }





    public static void main(String[] args) {


    }
}
