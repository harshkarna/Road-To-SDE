//Binary Search (Recursive)
//
//        Given an integer sorted array (sorted in increasing order) and an element x,
//        find the x in given array using binary search. Return the index of x.
//        Return -1 if x is not present in the given array.
//        Note : If given array size is even, take first mid.
//        Input format :
//
//        Line 1 : Array size
//
//        Line 2 : Array elements (separated by space)
//
//        Line 3 : x (element to be searched)
//
//        Sample Input :
//        6
//        2 3 4 5 6 8
//        5
//        Sample Output:
//        3

package com.Recusrion_Part2;

import java.util.Scanner;

public class RBinary_Search {

    public static int binarysearch(int[] arr,int start,int end ,int toSearch) {
        //Base case
        if (start == end) {
            if (arr[start] == toSearch) {
                return start;
            } else {
                return 0;
            }
        }

//        if (start >end){
//            return -1;
//        }

        int mid = (start + end) / 2;

        if (toSearch == arr[mid]) {
            return mid;
        } else if (toSearch > arr[mid]) {
            return binarysearch(arr, mid + 1, end, toSearch);
        } else {
            return binarysearch(arr, start, mid - 1, toSearch);
        }

    }
    public static int binarysearch(int arr[],int toSearch){

       return  binarysearch(arr,0,arr.length-1,toSearch);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of elements in Array");
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        System.out.println("Enter the  elements of Array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter To be Search ");
        int toSearch=sc.nextInt();
        System.out.println(binarysearch(arr,toSearch));

    }

}
