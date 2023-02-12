package com.PriorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElement {


    private static void printKSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

    public static void main(String[] args) {

        int[] arr={4,1,6,3,7,2,9,8};
        int k=3;
        printKSmallestElement(arr,k);


    }

}
