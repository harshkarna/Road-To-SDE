//First Index of Number
//
//        Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array.
//        Return -1 if it is not present in the array.
//        First index means, the index of first occurrence of x in the input array.
//        Do this recursively. Indexing in the array starts from 0.
//        Input Format :
//        Line 1 : An Integer N i.e. size of array
//        Line 2 : N integers which are elements of the array, separated by spaces
//        Line 3 : Integer x
//        Output Format :
//        first index or -1
//        Constraints :
//        1 <= N <= 10^3
//        Sample Input :
//        4
//        9 8 10 8
//        8
//        Sample Output :
//        1

package com.Recursion;

public class First_Index_of_Number {

    private static int find_index(int arr[],int x,int startIndex){
        if(startIndex==arr.length){
            return -1;
        }
        if(arr[startIndex]==x){
            return startIndex;
        }

        int smallcase=find_index(arr,x,startIndex+1);
        return smallcase;
    }

    public static int find_index(int arr[],int x){
        return find_index(arr,x,0);
    }


    public static void main(String[] args) {

        int arr[]={1,2,3,4};
        int x=1;
        System.out.println(find_index(arr,x));

    }
}
