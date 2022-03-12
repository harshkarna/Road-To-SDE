//Count Zeros
//
//        Given an integer N, count and return the number of zeros that are present in
//        the given integer using recursion.
//        Input Format :
//        Integer N
//        Output Format :
//        Number of zeros in N
//        Constraints :
//        0 <= N <= 10^9
//        Sample Input 1 :
//        10204
//        Sample Output 1 :
//        2
//        Sample Input 2 :
//        708000
//        Sample Output 2 :
//        4

package com.Recursion;

public class Count_Zeroes {

    public static int count_zeroes(int n){
        if(n==0){
            return 0;
        }

        int smallcase=count_zeroes(n/10);

        if((n % 10 ==0)){
            return smallcase +1;
        }
        else{
            return smallcase;
        }
    }

    public static void main(String[] args) {

        int n=50000;
        System.out.println(count_zeroes(n));

    }
}
