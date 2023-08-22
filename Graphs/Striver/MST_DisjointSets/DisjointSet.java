package com.Graphs.Striver.MST_DisjointSets;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <=n; i++) {
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



    public int getTotalComponents() {
        int count = 0;
        for (int i = 1; i <parent.size(); i++) {
            if (parent.get(i) == i) {
                count++;
            }
        }
        return count;
    }

    public int getTotalComponents(int nodes) {
        int count = 0;
        for (int i = 0; i < nodes; i++) {
            if (parent.get(i) == i) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int n =7;
        DisjointSet ds = new DisjointSet(n);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
//        if (ds.findUPar(3) == ds.findUPar(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");

        System.out.println(ds.getTotalComponents());

//        ds.unionBySize(3, 7);
//        if (ds.findUPar(3) == ds.findUPar(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");

//        System.out.println(ds.getTotalComponents());

    }

}
