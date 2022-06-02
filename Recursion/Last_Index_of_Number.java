//Last Index of Number
//
//        Given an array of length N and an integer x, you need to find and return the last index of integer
//        present in the array. Return -1 if it is not present in the array.
//        Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
//        You should start traversing your array from 0, not from (N - 1).
//        Do this recursively. Indexing in the array starts from 0.
//        Input Format :
//        Line 1 : An Integer N i.e. size of array
//        Line 2 : N integers which are elements of the array, separated by spaces
//        Line 3 : Integer x
//        Output Format :
//        last index or -1
//        Constraints :
//        1 <= N <= 10^3
//        Sample Input :
//        4
//        9 8 10 8
//        8
//        Sample Output :
//        3


package com.Recursion;

public class Last_Index_of_Number {

    public static int last_index(int arr[],int x,int startIndex){
        if(startIndex==arr.length){
            return -1;
        }

        int smallcase=last_index(arr,x,startIndex+1);

        if (smallcase!=-1){
            return smallcase;
        }

        if (arr[startIndex]==x){
            return startIndex;
        }
        else {
            return -1;
        }
    }

//    public static int last_index(int arr[],int x,int startIndex){
//
//        if(startIndex==arr.length){
//            return -1;
//        }
//
//        int small_case=last_index(arr,x,startIndex+1);
//
//        if(small_case!=-1){  //once we get our last value , so while going above the pointer will always come to this
//            return small_case;
//        }
//
//        else if(arr[startIndex]==x){  //this will only 1 time when last index will be encountered
//            return startIndex;
//        }
//        else return -1;  //this will happen happen the last element is not the value we are looking for
//
//    }

    public static int last_index(int arr[],int x) {
        return last_index(arr, x, 0);

    }
        public static void main(String[] args) {

        int arr[]={2,2,3};
        int x=2;

        last_index(arr,x);

        System.out.println(last_index(arr,x));
    }

}
