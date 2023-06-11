/*Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

        Example 1:

        Input:
        Intervals = {{1,3},{2,4},{6,8},{9,10}}
        Output: {{1, 4}, {6, 8}, {9, 10}}
        Explanation: Given intervals: [1,3],[2,4]
        [6,8],[9,10], we have only two overlapping
        intervals here,[1,3] and [2,4]. Therefore
        we will merge these two and return [1,4],
        [6,8], [9,10].
        */
package com.SDESheet.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
/*

Same approach just variable taken different

    public int[][] overlappedInterval(int[][] Intervals)
    {
        Arrays.sort(Intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = Intervals[0];
        for (int i = 1; i < Intervals.length; i++) {
            //if new interval first is smaller  or equal than current last
            //it means its part of the interval
            if (Intervals[i][0] <= currentInterval[1]) {
                //if yes , then update current interval last , as max of new or current
                currentInterval[1] = Math.max(currentInterval[1], Intervals[i][1]);
            } else {
                //if its not the part , the currentInterval is completed , add it to the ans
                merged.add(currentInterval);
                currentInterval = Intervals[i];
            }
        }
        //for the last interval
        merged.add(currentInterval);
        return merged.toArray(new int[merged.size()][]);
    }
*/

    public static int[][] overlappedInterval(int[][] intervals)
    {
        Arrays.sort(intervals);
        List<int[]> merged = new ArrayList<>();
//        int[] currentInterval = intervals[0];
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //if new interval first is smaller  or equal than current last
            //it means its part of the interval
            if (intervals[i][0] <= end) {
                //if yes , then update current interval last , as max of new or current
                end = Math.max(end, intervals[i][1]);
            } else {
                //if its not the part , the currentInterval is completed , add it to the ans
                merged.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        //for the last interval
        merged.add(new int[]{start,end});
        //way to convert list of array into 2d array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {


    }
}
