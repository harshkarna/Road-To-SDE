package com.PriorityQueues;

import java.util.PriorityQueue;

public class Find_kLargest {

    private static void printKlargest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
       //First add all elements in queue by defaultb  min heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(pq.peek() <arr[i]){
                //we need to replace
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
        printKlargest(arr,k);
    }


}
