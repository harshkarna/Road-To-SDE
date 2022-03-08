//All Indices of Number
//
//        Given an array of length N and an integer x, you need to find all the indexes where
//        x is present in the input array. Save all the indexes in an array (in increasing order).
//        Do this recursively. Indexing in the array starts from 0.
//        Input Format :
//        Line 1 : An Integer N i.e. size of array
//        Line 2 : N integers which are elements of the array, separated by spaces
//        Line 3 : Integer x
//        Output Format :
//        indexes where x is present in the array (separated by space)
//        Constraints :
//        1 <= N <= 10^3
//        Sample Input :
//        5
//        9 8 10 8 8
//        8
//        Sample Output :
//        1 3 4

package com.Recursion;

public class All_indices_of_a_number {

    // not good solution
    public static void all_index(int arr[],int x,int startIndex){

        if(startIndex==arr.length){
           return;
        }

        if(arr[startIndex]==x){
            System.out.print(startIndex+ " ");
        }

       all_index(arr,x ,startIndex+1);

    }

    public static void all_index(int arr[],int x) {

         all_index(arr, x, 0);
    }

    public static void main(String[] args) {


        int arr[]={9,8,10,8,8};
        int x=8;

        all_index(arr,x);

    }
}
