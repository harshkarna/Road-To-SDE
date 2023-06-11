/*Given start, end and an array arr of n numbers. At each step, start is multiplied with

 any number in the array and then mod operation with 100000 is done to get the new start.
        Your task is to find the minimum steps in which end can be achieved starting from start.
        If it is not possible to reach end, then return -1.

        Example 1:

        Input:
        arr[] = {2, 5, 7}
        start = 3, end = 30
        Output:
        2
        Explanation:
        Step 1: 3*2 = 6 % 100000 = 6
        Step 2: 6*5 = 30 % 100000 = 30*/
package com.Graphs.Striver.ShortestPathAlgos;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationstoreachEnd {

    public static class Pair{
        int steps;
        int node;
        public Pair(int steps,int node){
            this.steps = steps;
            this.node = node;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        // Create a queue for storing the numbers as a result of multiplication
        // of the numbers in the array and the start number.
        //we can use simple queue here as steps will increase by unit distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));

        // Create a dist array to store the no. of multiplications to reach
        // a particular number from the start number
        // as our node cant go beyond 10^5 .
        int[] dist = new int[100000];

        for(int i = 0;i<100000;i++) dist[i] = (int)(1e9);
        dist[start] = 0;

        int mod = 100000;
        int n = arr.length;
        // O(100000 * N)

        // Multiply the start no. with each of numbers in the arr
        // until we get the end no.
        while(!q.isEmpty()) {
            int node = q.peek().node;
            int steps = q.peek().steps;
            q.remove();

            for(int i = 0;i < n; i++) {
                int num = (arr[i] * node) % mod;

                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if(steps + 1 < dist[num]) {
                    dist[num] = steps + 1;

                    // Whenever we reach the end number
                    // return the calculated steps
                    if(num == end) return steps + 1;
                    q.add(new Pair(steps + 1,num));
                }
            }
        }
        // If the end no. is unattainable.
        return -1;
    }

    public static void main(String[] args) {

    }
}

