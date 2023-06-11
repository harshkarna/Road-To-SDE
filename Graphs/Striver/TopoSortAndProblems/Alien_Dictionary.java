package com.Graphs.Striver.TopoSortAndProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alien_Dictionary {

    public static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //create the in degree array
        int[] indegree=new int[V];
        // fill up the  in degree array
        for(int i =0; i <V ;i++){
            for(int adjacentNode : adj.get(i)){
                indegree[adjacentNode]++;
            }
        }

        //Now traverse over the array and push the nodes in queue whose indegree is zero
        Queue<Integer> pendingNodes=new LinkedList<>();
        for(int i =0 ; i < V ;i++){
            if(indegree[i]==0){
                pendingNodes.add(i);
            }
        }

        //Someone will obviously will be having indegree as 0 as its DAG graph --doubt

        //create an array to store linear ordering
        ArrayList<Integer> topo=new ArrayList<>();
        int i=0;
        while(!pendingNodes.isEmpty()){
            int node=pendingNodes.poll();
            //add this node in final ordering array
            topo.add(node);

            //node is in your topo sort
            //so please remove it from indegree
            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;
                if(indegree[adjacentNode]==0){
                    pendingNodes.add(adjacentNode);
                }
            }
        }
        return topo;
    }

    public  static String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        //create arr for k size as k is the total no of letters from which words are being made
        for(int i =0; i < K;i++){
            adj.add(new ArrayList<>());
        }

        //now lets traverse over the dict pair by pair
        //till n-1 because we need pair i and i+1
        for(int i=0 ;i < N-1; i++){
            String s1=dict[i];
            String s2=dict[i+1];
            //now we need to compare every letter of s1 and s1 , and we will
            //compare till the min len( s1 or s2)
            int len =Math.min(s1.length(), s2.length());
            for(int ptr=0 ;ptr < len; ptr++){
               if(s1.charAt(ptr) !=s2.charAt(ptr)){
                   //now if you found the letter diff, it means s1 appear before s2
                   //therefore there should be a edge from s1 [ptr]-> s2 [ptr]
                   //doing - 'a' to convert into numeric
                   adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                   break;
               }
            }
        }

        //now you have your adj list created , now just pass it to the top sort function
        ArrayList<Integer> topo=  topoSort(K, adj);
        //now we  need to convert the numeric back to its alphabet form
        String ans ="";
        //doubt
        for(int i : topo){
            ans = ans + (char)( i +'a');
            System.out.println(i +" - > "  + ans );

        }
        return ans ;

    }

    public static void main(String[] args) {
        int N=5;
        int K=4;
        String[] dict = { "baa","abcd","abca","cab","cad"};
        String  ans = findOrder(dict, N,K);
        System.out.println(ans);

    }
}
