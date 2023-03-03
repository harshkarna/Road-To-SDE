package com.PriorityQueues;

import com.Linked_List.Node;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class merge_k_sorted_linkedList {

    /*Approach :Optimised Approach
    * 1.First lets store every first node of LL in min Heap.
    * 2. We need to return a LL as a mergeD ll , create a ans LL.
    * 3.
    *
    * */



    public static Node<Integer> mergeKLists(Node<Integer>[] listArray){

        PriorityQueue<Node<Integer>> pq=new PriorityQueue<>();

        //Step 1:Putt the first element of every list in min heap
        int k=listArray.length;
        //one special case
        if(k==0){
          return null;
        }
        for(int i =0;i< k;i++){
            if(listArray[i] != null){
                pq.add(listArray[i]);
            }
        }
        //create a ans LL
        Node<Integer> head= null;
        Node<Integer> tail =null;

        while(!pq.isEmpty()){
            Node<Integer> top= pq.peek();
            pq.poll();

            //check here only if next element of that LL is present , enter that in heap
            if(top.next!=null){
                pq.add(top.next);
            }


            if(head==null){
                //if ans LL is empty
                head=top;
                tail=top;
            }
            else{
                //if LL already filled
                tail.next=top;
            }
        }
        return head;

    }

    public static void main(String[] args) {

        


    }
}
