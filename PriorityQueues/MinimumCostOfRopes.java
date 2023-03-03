/*
There are given N ropes of different lengths, we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths. The task is to connect
 the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes.

        Example 1:

        Input:
        n = 4
        arr[] = {4, 3, 2, 6}
        Output:
        29
        Explanation:
        We can connect the ropes in following ways.
        1) First connect ropes of lengths 2 and 3.
        Which makes the array {4, 5, 6}. Cost of
        this operation 2+3 = 5.
        2) Now connect ropes of lengths 4 and 5.
        Which makes the array {9, 6}. Cost of
        this operation 4+5 = 9.
        3) Finally connect the two ropes and all
        ropes have connected. Cost of this
        operation 9+6 =15
        Total cost for connecting all ropes is 5
        + 9 + 15 = 29. This is the optimized cost
        for connecting ropes.
        Other ways of connecting ropes would always
        have same or more cost. For example, if we
        connect 4 and 6 first (we get three rope of 3,
        2 and 10), then connect 10 and 3 (we get
        two rope of 13 and 2). Finally we
        connect 13 and 2. Total cost in this way
        is 10 + 13 + 15 = 38.
*/

package com.PriorityQueues;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    /*Step 1: take the 2 min elements every time , best way to put all elemenets in heap.
    2. sum those 2 and add in total count and remember to poll out also from heap .
    3.repeat the process until array size =1.
    * */

    public static int minCost(int arr[], int n)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // Adding items to the pQueue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int cost=0;

        while(pq.size() > 1){
            int a =pq.poll();
            int b =pq.poll();
            int sum=a+b;
            cost+=sum;

            pq.add(sum);

        }
        return cost;

    }

    public static void main(String[] args) {

        int[] arr={4,3,2,6};
        int n =4;
        System.out.println(minCost(arr,n));


    }
}
