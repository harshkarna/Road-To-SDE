//Sum of digits (recursive)
//
//        Write a recursive function that returns the sum of the digits of a given integer.
//        Input format :
//        Integer N
//        Output format :
//        Sum of digits of N
//        Constraints :
//        0 <= N <= 10^9
//        Sample Input 1 :
//        12345
//        Sample Output 1 :
//        15
//        Sample Input 2 :
//        9
//        Sample Output 2 :
//        9

package com.Recursion;

public class Sum_of_digits {

    public static int sum(int n){
        if(n==0){
            return 0;
        }
        int smallcase=sum(n/10);
        return smallcase + n%10;
    }

    public static void main(String[] args) {
        int n=9;
        System.out.println(sum(n));

    }
}
