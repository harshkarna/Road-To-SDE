//
//Sum of Array
//
//        Given an array of length N, you need to find and return the sum of all elements of the array.
//        Do this recursively.
//        Input Format :
//        Line 1 : An Integer N i.e. size of array
//        Line 2 : N integers which are elements of the array, separated by spaces
//        Output Format :
//        Sum
//        Constraints :
//        1 <= N <= 10^3
//        Sample Input 1 :
//        3
//        9 8 9
//        Sample Output 1 :
//        26
//        Sample Input 2 :
//        3
//        4 2 1
//        Sample Output 2 :
//        7
package com.Recursion;

public class Sum_of_array {

    public static int sum_array(int arr[]){
        if(arr.length==1){
            return arr[arr.length-1];
        }

        int small_case_arr[]= new int[arr.length-1];
        for(int i=1;i<arr.length;i++){
            small_case_arr[i-1]=arr[i];
        }
        int smallcase=sum_array(small_case_arr);
        return arr[0]+smallcase;

    }


    public static void main(String[] args) {

        int arr[]={4,2,-1};
        System.out.println(sum_array(arr));

    }
}
