package com.PriorityQueues;

import java.util.PriorityQueue;

public class InbuiltPQ {

    public static void main(String[] args) {
        int[] arr={4,3,7,6,9,10,1,2};
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i< arr.length;i++){
            pq.add(arr[i]);
        }

        System.out.println("Top " + pq.peek());

        System.out.println();

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }

    }
}