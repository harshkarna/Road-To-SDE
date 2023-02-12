package com.PriorityQueues;

public class BuildMaxHeap {

    private static void heapifyAlgo(int[] arr, int size , int i) {
        //For max heap lets store the ith in largest
        int largest=i;
        int leftChild=2*i+1;
        int rightChild=2*i+2;

        //if its left child is greater than parent , replace largest index with leftchild index;
        if(leftChild < size  && arr[leftChild] > arr[largest]){
            largest=leftChild;
        }

        //if its right child is greater than parent , replace largest index with rightchild index;
        if(rightChild < size  && arr[rightChild] > arr[largest]){
            largest=rightChild;
        }

        //here if  we get to know if i is not equal to largest then just swap element of i and elemnent of largest
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapifyAlgo(arr,size,largest);
        }

    }

    public static void main(String[] args) {

        //Time complexity =O(n);

        int[] arr={54,55,53,52,50};
        int n= arr.length;
        //here we are starting from n/2 -1 as from here non leaf will start to top;
        //we are passing arr , size and ith node for that heapify will take it to its corrrect position
        for(int i=n/2-1;i>=0;i--){
            heapifyAlgo(arr,n,i);
        }

        for(int i:arr){
            System.out.print(i +" ");
        }

  }

}
