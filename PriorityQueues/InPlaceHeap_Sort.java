/*
Inplace Heap Sort

        Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
        Note: Space complexity should be O(1).
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array or N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output Format :
        The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
        Constraints :
        1 <= n <= 10^6
        Time Limit: 1 sec
        Sample Input 1:
        6
        2 6 8 5 4 3
        Sample Output 1:
        8 6 5 4 3 2

*/

package com.PriorityQueues;

public class InPlaceHeap_Sort {

    private static void downheapify(int[] arr, int i, int n) {
       int parentIndex=i;
       int leftChildindex=2*parentIndex+1;
       int rightChildindex=2*parentIndex+2;

       while(leftChildindex < n) {
           int minIndex = parentIndex;
           if (arr[leftChildindex] < arr[minIndex]) {
               minIndex = leftChildindex;
           }
           if (rightChildindex < n && arr[rightChildindex] < arr[minIndex]) {
               minIndex = rightChildindex;
           }

           if (minIndex == parentIndex) {
               return;
           }

           int temp = arr[parentIndex];
           arr[parentIndex] = arr[minIndex];
           arr[minIndex] = temp;
           parentIndex = minIndex;
           leftChildindex = 2 * parentIndex + 1;
           rightChildindex = 2 * parentIndex + 2;

       }

    }

    private static void heapSort(int[] arr) {
        //1.build the heap
        int n =arr.length;
        for(int i=(n/2)-1;i>=0;i--){
            downheapify(arr,i,n);
        }
        //Once heap is built we will remove elements from starting one by one ,
        //and put them at respective last position.
        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            downheapify(arr,0,i);
        }

    }

    public static void main(String[] args) {
     int[] arr={4,7,3,2,8,9,6};
     heapSort(arr);
     for(int i=0;i<arr.length;i++){
         System.out.println(arr[i]);
      }
    }

}
