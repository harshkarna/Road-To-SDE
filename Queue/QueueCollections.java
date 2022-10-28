package com.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        System.out.println(queue.size());
        System.out.println(queue.peek());//to see the front element
        System.out.println(queue.poll());//to remove the element
        System.out.println(queue.size());


    }
}
