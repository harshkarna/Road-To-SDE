package com.PriorityQueues;

class Solution{

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
        if(rightChild < size  && arr[rightChild ] > arr[largest]){
            largest=rightChild;
        }

        //here if  we get to know if i is not equal to largest then just swap element of i and elemnent of largest
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapifyAlgo(arr,size, largest);
        }

    }


    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // step 1" merger both arrays intp 1

        int res[]=new int[n+m];
        int k=0;
        for(int i=0;i<n;i++){
            res[k++]=a[i];
        }
        for(int j=0;j<m;j++){
            res[k++]=b[j];
        }

        //step 2: build heap using merged array
        int len=res.length;
        for(int i=len/2-1;i>=0;i--){
            heapifyAlgo(res,len,i);
        }

        return res;

        //
    }

    public static void main(String[] args) {


    }
}