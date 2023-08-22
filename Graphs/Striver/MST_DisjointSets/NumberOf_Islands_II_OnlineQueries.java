/*You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the
number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally,
the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each
operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from
 sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
        Note : An island means group of 1s such that they share a common side.


        Example 1:

        Input: n = 4
        m = 5
        k = 4
        A = {{1,1},{0,1},{3,3},{3,4}}

        Output: 1 1 2 2
        Explanation:

        00000
        00000
        00000
        00000

      1.00000
        01000
        00000
        00000

    2.  01000
        01000
        00000
        00000

    3.  01000
        01000
        00000
        00010

    4.  01000
        01000
        00000
        00011*/

package com.Graphs.Striver.MST_DisjointSets;


import java.util.ArrayList;
import java.util.List;

public class NumberOf_Islands_II_OnlineQueries {

    static class  DisjointSetv1 {
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        public DisjointSetv1(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int n =rows;
        int m =cols;
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len ; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            //if same operator comes , means its already an island
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;

            //now will check in 4 directions
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (adjr >= 0 && adjr < n && adjc >= 0 && adjc < m && vis[adjr][adjc] == 1) {
                       //below we are  calculating node
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;
                        //if their ultimate parent is not equal means we need to connect them , and reduce  total count by 1
                        //as we in increased earlier
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                }
            }
            ans.add(cnt);
        }
        return ans;


    }

        public static void main(String[] args) {


    }


}
