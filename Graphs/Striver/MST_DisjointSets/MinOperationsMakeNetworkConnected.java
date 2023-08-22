package com.Graphs.Striver.MST_DisjointSets;

import java.util.ArrayList;

public class MinOperationsMakeNetworkConnected {

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

    public int Solve(int n, int[][] edge) {
        DisjointSetv1 ds = new DisjointSetv1(n);
        int cntExtras = 0;
        int m = edge.length;
        for (int[] ints : edge) {
            int u = ints[0];
            int v = ints[1];
            //if 2 nodes which shares edges has same parent , means they are already connected via parent node
            //thus we can say this is an extra edge and use for joining other node
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntExtras++;
            } else {
                //if 2 nodes is not connected , connect them
                ds.unionBySize(u, v);
            }
        }
        //now we are checking no of components as we need (no of components) -1 edges overall to join them
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) cntC++;
        }
        int ans = cntC - 1;
        //so if we have extra edges = or > than edges , we can connect the graph
        if (cntExtras >= ans) return ans;
        return -1;
    }


    public static void main(String[] args) {


    }
}
