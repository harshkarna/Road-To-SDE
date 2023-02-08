package com.PriorityQueues;

import java.util.ArrayList;

// 1. It have to CBT
// 2. Maintain Heap order property
public class PriorityQueue<T> {

    private ArrayList<Elements<T>> heap;
    public PriorityQueue(){
        heap=new ArrayList<>();
    }

    public void insert(T value, int priority){
       Elements<T> e=new Elements<>(value,priority);
       heap.add(e);
       int childIndex=heap.size()-1;
       int parentIndex=(childIndex-1)/2;
       while(childIndex > 0){
           if(heap.get(childIndex).priority < heap.get(parentIndex).priority){
               Elements<T> temp=heap.get(childIndex);
               heap.set(childIndex,heap.get(parentIndex));
               heap.set(parentIndex,temp);
               childIndex=parentIndex;
               parentIndex=(childIndex-1)/2;
           }
           else{
               return;
           }
       }

    }

    public T getMin() throws PriorityQueueException {
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        return heap.get(0).value;

    }
//    public T removeMin() throws PriorityQueueException {
//        if(isEmpty()){
//            throw new PriorityQueueException();
//        }
//
//    }

    public int size(){
       return heap.size();
    }

    public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        else{
            return false;
        }
    }

}
