/*There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi , toi ,weighti]
 represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distance Threshold.
 You need to find out a city with the smallest number of cities that are reachable through some path and
 whose distance is at most Threshold Distance, If there are multiple such cities, our answer will be the city with the greatest number.

        Note: that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

        Example 1:

        Input:
        N=4,M=4
        edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]]
        distanceThreshold = 4
        Output:3
        Explaination:

        The neighboring cities at a distanceThreshold = 4 for each city are:
        City 0 -> [City 1, City 2]
        City 1 -> [City 0, City 2, City 3]
        City 2 -> [City 0, City 1, City 3]
        City 3 -> [City 1, City 2]
        Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number

        .*/

package com.Graphs.Striver.ShortestPathAlgos;
public class CitySmallestNumberNeighboursThresholdDistance {

   public static int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = (int)(1e9);
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        //mark themselves one as zero
        for (int i = 0; i < n; i++) dist[i][i] = 0;

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++){
//                System.out.print(dist[i][j]+ " ");
//            }
//            System.out.println();
//
//        }
//        System.out.println();


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++){
//                System.out.print(dist[i][j]+ " ");
//            }
//            System.out.println();
//
//        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
        int[][] edges={{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int threshold=2;
        System.out.println(findCity(5,6,edges,threshold));

    }
}
