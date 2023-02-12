/*
Check Max-Heap

        Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
        Input Format:
        The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
        The following line contains N space separated integers, that denote the value of the elements of the array.
        Output Format :
        The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.
        Constraints:
        1 <= N <= 10^5
        1 <= Ai <= 10^5
        Time Limit: 1 sec
        Sample Input 1:
        8
        42 20 18 6 14 11 9 4
        Sample Output 1:
        true
*/

package com.PriorityQueues;

public class CheckMaxHeap {

    public static boolean checkMaxheap(int arr[]){
        int n = arr. length;
        //here we we will run loop till non leaf nodes so that why 2i +1 < n;
        for (int i = 0; 2 * i + 1 < n; i++) {

            int leftChildIndex = 2 * i + 1;
            int rightChildIndex =  2 * i+ 2;
//            if left child greater than parent then return false
            if (arr[i] < arr[leftChildIndex]) {
                return false;
            }
//               if  right child exists and is greater than parent then return false
                if (rightChildIndex < n && arr[i] < arr[rightChildIndex]) {
                    return false;
                }
            }
        return true;

    }


    public static void main(String[] args) {

        int[] arr={42,20,18,6,14,11,9,4};
        System.out.println(checkMaxheap(arr));
    }
}
