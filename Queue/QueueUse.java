package com.Queue;

public class QueueUse {

    public static void main(String[] args) throws QueueFullException, QueueEmptyExcpetion {
       QueueUsingArray queue =new QueueUsingArray(3);
       int arr[]={10,20,30,40,60};
       for(int elem :arr){
           queue.enqueue(elem);
       }

       while(!queue.isEmpty()){
           System.out.println(queue.dequeue());
       }

    }
}
