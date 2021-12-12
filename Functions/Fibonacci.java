//Fibonacci Number
//
//        Given a number N, figure out if it is a member of fibonacci series or not.
//        Return true if the number is member of fibonacci series else false.
//        Fibonacci Series is defined by the recurrence
//        F(n) = F(n-1) + F(n-2)
//        where F(0) = 0 and F(1) = 1
//
//
//        Input Format :
//        Integer N
//        Output Format :
//        true or false
//        Constraints :
//        0 <= n <= 10^4
//        Sample Input 1 :
//        5
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        14
//        Sample Output 2 :
//        false
//


package com.Functions;
public class Fibonacci {

    public static void main(String[] args) {

        int a=0;
        int b=1;
        System.out.print(a+ " " +b+ " ");
        int c;

        for (int i=0;i<10;i++){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }


    }
}
