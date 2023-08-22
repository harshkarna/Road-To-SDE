package com.Dynamic_Programing.Striver.DP_Grids;

import java.util.Arrays;

public class Ninja_Training {

    static int ninjaTrainingRec(int day, int last, int[][] points) {

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return  maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaTrainingRec(day - 1, i, points);
                maxi = Math.max(maxi, activity);
            }

        }
        return maxi;
    }

    static int ninjaTrainingRec(int n, int[][] points) {

        return ninjaTrainingRec(n - 1, 3, points);
    }


    static int ninjaTrainingMemo(int day, int last, int[][] points, int[][] dp) {

        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaTrainingMemo(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

    static int ninjaTrainingMemo(int n, int[][] points) {

        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        return ninjaTrainingMemo(n - 1, 3, points, dp);
    }


    static int ninjaTrainingTab(int n, int[][] points) {


        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }

    static int ninjaTrainingSpaceOptimised(int n, int[][] points) {


        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], activity);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }


    public static void main(String args[]) {

        int[][] points = {{1,2,5},
                {3,1,1},
                {3,3,3}};

        int n = points.length;
        System.out.println(ninjaTrainingMemo(n, points));
    }

}

