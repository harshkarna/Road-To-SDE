package com.Graphs.Striver.MST_DisjointSets;


import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KrushkalsAlgorithm {
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


    public static class Pair {
        int source ;
        int destination;
        int weight;

        public Pair(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight=weight;

        }
    }

    public static int spanningTree(int V, int E, int edges[][]){

        ArrayList<Pair> adj = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            int weight = edges[i][2];
            adj.add(new Pair(source, destination, weight));
        }

        // Sort the ArrayList based on weights
        Collections.sort(adj, (x, y) -> x.weight - y.weight);

        DisjointSetv1 ds = new DisjointSetv1(V);

        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < adj.size(); i++) {
            int wt = adj.get(i).weight;
            int u = adj.get(i).source;
            int v = adj.get(i).destination;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }

    public static void main(String[] args) {


    }

}
