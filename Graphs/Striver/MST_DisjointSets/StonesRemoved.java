package com.Graphs.Striver.MST_DisjointSets;

import java.util.ArrayList;

public class StonesRemoved {
    static class  DisjointSetv1 {
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        public DisjointSetv1(int n) {
            for (int i = 0; i <= n; i++) {
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

        public int getTotalComponents(int n)  {
            int count = 0;
            for (int i = 0; i <n; i++) {
                if (parent.get(i) == i) {
                    count++;
                }
            }
            return count;
        }
    }

/*
     Now the idea here is , if a stone shares either row or col with any other stone so
     that particular stone can be removed . So basically here we're uniting all those stones
     which shares either row or col , because if we observe carefully in 1 connected component
     we can remove all stones except 1 . So here our motive will be finding all distinct components,
     and  then we can do  ( No. of Nodes - no of components ) (derived below)

     Suppose there are below n connected comp with each having certain number of stones
     C1 have x1 stones
     C2 has x2 stones
     C3 has x3 stone
     .....So CN has Xn stones

     and we know each stone we have assumed as a node
     so x1 + x2+ x3 ....xN = Total no of nodes

     Now we know  we can remove all stones except 1 node in each component
     c1         c2       c3               Cn
     (x1-1) + (x2 -1) + (x3-1) + .........(xn-1)

     x1 + x2+ x3 ....xn  - (1 +1 +1 +1 ......n)

     = Total no of nodes  - Total no. of Connected Components


     The time complexity of the optimized code is O(n * α(n)), where n is the number of stones and α(n) is the inverse Ackermann function.

       The primary reason for this improvement in time complexity is that we keep track of the number of components
       (count) during the union operations. Since each union operation takes O(α(n)) time
       (due to path compression and union by size in the disjoint set data structure),
        and there can be at most n - 1 union operations (to connect all the stones in the
        same row or column), the total time complexity for the union operations becomes O(n * α(n)).



*/

    public  static int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSetv1 ds = new DisjointSetv1(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    ds.unionBySize(i, j);
                }
            }
        }
        return n - ds.getTotalComponents(n);
    }


    public static void main(String[] args) {

       int[][] stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));




    }

}
