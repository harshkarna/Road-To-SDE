/*You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
        and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.

        Example 1:

        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
        Example 2:

        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

        */
package com.LeetcodeDaily;

import sun.print.CUPSPrinter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void print2DArray(int[][] arr){
        //display 2D Array
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] currentInterval : intervals) {
            if (currentInterval[1] < newInterval[0]) {
            //  its means we are left of new interval
                result.add(currentInterval);
            }
            else if (currentInterval[0] > newInterval[1]){
                //its means we are right of new interval
                //so it means overlapping process over , now whatever merger happened in new interval add
                //that in result and move to next element and make it new interval
                result.add(newInterval);
                newInterval= currentInterval;
            }
            //Now comes the overlapping scenario as left and right scenario already taken care above
            else{
                newInterval[0]=Math.min(newInterval[0],currentInterval[0]);
                newInterval[1]=Math.max(newInterval[1],currentInterval[1]);
            }

            // insert the last newInterval

            result.add(newInterval);

        }

        //this is how we convert Linked list<array> t0 2d array
        int[][] finalresult = new int[result.size()][];
        for(int i=0;i<result.size();i++){
            finalresult[i] = result.get(i);
        }
        return finalresult;
//        return result.toArray(new int[result.size()][]);

    }



    public static void main(String[] args) {
       int[][] intervals = {{1,3},{6,9}};
       int[] newInterval = {2,5};
       print2DArray(insert(intervals,newInterval));

    }
}
