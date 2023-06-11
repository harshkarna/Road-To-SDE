/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is
connected directly with city c, then city a is connected indirectly with city c.

        A province is a group of directly or indirectly connected cities and no other cities outside of the group.

        You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
        and isConnected[i][j] = 0 otherwise.

        Return the total number of provinces.*/

package com.Graphs.Striver.ProblemsOnBFSDFS;

public class NumberOfProvince {

    /*
    To--- O(n) + O(v +2e) and not O(n) * O(v +2e)
    * */

    public static void dfs(int[][] isConnected, int currentVertex, boolean[] visited){
        visited[currentVertex]=true;
        for(int i=0; i < isConnected.length;i++){
            if(isConnected[currentVertex][i]==1 & !visited[i]){
                // i is the neighbour of current vertex
                dfs(isConnected,i,visited);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0; i < n ;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {


    }


}
