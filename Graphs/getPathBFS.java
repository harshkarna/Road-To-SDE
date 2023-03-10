/*Get Path - BFS

        Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
        Find the path using BFS and print the shortest path available.
        Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
        4. Save the input graph in Adjacency Matrix.
        Input Format :
        The first line of input contains two integers, that denote the value of V and E.
        Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
        The following line contain two integers, that denote the value of v1 and v2.
        Output Format :
        Print the path from v1 to v2 in reverse order.
        Constraints :
        2 <= V <= 1000
        1 <= E <= (V * (V - 1)) / 2
        0 <= a <= V - 1
        0 <= b <= V - 1
        0 <= v1 <= 2^31 - 1
        0 <= v2 <= 2^31 - 1
        Time Limit: 1 second
        Sample Input 1 :
        4 4
        0 1
        0 3
        1 2
        2 3
        1 3
        Sample Output 1 :
        3 0 1
        Sample Input 2 :
        6 3
        5 3
        0 1
        3 4
        0 3
        Sample Output 2 :*/
package com.Graphs;

import java.util.*;

public class getPathBFS {

    public static ArrayList<Integer> bfsTravelHelper(int adjMatrix[][], int sv, int ev, boolean visited[]){
        //check for invalid cases
        if (sv > (adjMatrix.length - 1) || ev > (adjMatrix.length - 1)){
            return null;
        }
        //if sv and ev are same
        if (adjMatrix[sv][ev] == 1 && sv == ev) {
            ArrayList<Integer> ans = new ArrayList<> ();
            ans.add (sv);
            return ans;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> pendingVetices=new LinkedList<>();
        visited[sv]=true;
        pendingVetices.add(sv);

        while(!pendingVetices.isEmpty()){
            int currentVertex=pendingVetices.poll();
            for(int i=0;i <adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i]==1 && !visited[i]){
                    //here in map we are putting parent of i i.e currentVertex in map
                    map.put(i, currentVertex);
                    //i is unvisited neighbour of current vertex
                    pendingVetices.add(i);
                    visited[i]=true;

                    if(i == ev) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        int current = ev;
                        ans.add(ev);
                        while(current != sv) {
                            //get parent of current and push in ans till current is = to source
                            current =map.get(current);
                            ans.add(current);
                        }
                        return ans;
                    }
                }
            }
        }
        return null;
    }
    public static ArrayList<Integer> getPathbfsTravel(int adjMatrix[][],int sv, int ev){
        boolean visited[] =new boolean[adjMatrix.length];
        return bfsTravelHelper(adjMatrix,sv,ev, visited);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter no of vertices");
        int n=sc.nextInt(); //no of vertices
        System.out.println(" Enter no of edges");
        int e=sc.nextInt(); // no of edges

        int adjMatrix[][]=new int[n][n]; //creating n by n matrix

        for(int i=0;i < e ;i++){
            //here we are giving  edges between vertices and then filling 2d array both way
//            System.out.println("Enter the first vertex of current edge");
            int v1=sc.nextInt();
//            System.out.println("Enter the second vertex of current edge");
            int v2=sc.nextInt();
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1;
        }
        int sv=0;
        int ev=3;
        ArrayList<Integer> ans = getPathbfsTravel(adjMatrix, sv, ev);
        if(ans != null) {
            for (int elem : ans) {
                System.out.print(elem+" --> ");
            }
        }
    }

}
