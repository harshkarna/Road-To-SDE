package com.First_Steps;
//All primes
//
//You are given a single positive integer, N. You need to print all prime numbers that occur in the range 1 to N (both inclusive).
//Draw a flowchart for this process
//Note : You don't need to submit the problem. Just attempt in your notebook and ask doubts if you need help.


//Need More Optimise solution

public class AllPrime {

    public static void allprime(int n) {

        for (int i = 2; i <= n; i++) {
            if (i==2){
                System.out.println(2);
            }
            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    break;
                }
                else if (k == i-1){
                    System.out.println(i);
                }
            }

        }
    }

    public static void main(String[] args) {
        allprime(100);
    }
}