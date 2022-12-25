package com.Collections.List;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueClass {

    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());// to get max element first,
        //works like maxheap


        pq.offer(40);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);

        System.out.println(pq);
        //here min heap is been implemented , so minimum element is popping up first
        pq.poll();
        System.out.println(pq);

        System.out.println(pq.peek());

    }
}
