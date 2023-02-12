package com.PriorityQueues;

public class BuildMinHeap {

        private static void heapifyAlgo(int[] arr, int size , int i) {
            int smallest=i;
            int leftChild=2*i+1;
            int rightChild=2*i+2;

            if(leftChild < size  && arr[leftChild] < arr[smallest]){
                smallest=leftChild;
            }

            if(rightChild < size  && arr[rightChild] < arr[smallest]){
                smallest=rightChild;
            }

            if(smallest!=i){
                int temp=arr[smallest];
                arr[smallest]=arr[i];
                arr[i]=temp;
                heapifyAlgo(arr,size,smallest);
            }

        }
        public static int[] buildMinHeap(int[] arr)
        {
            int n= arr.length;
            for(int i=n/2 -1;i>=0;i--){
                heapifyAlgo(arr,n,i);
            }

            return arr;

        }

}
