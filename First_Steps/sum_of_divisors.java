package com.First_Steps;

public class sum_of_divisors {

    static long sumOfDivisors(int N){
        // code here
        long sum = 0;
        long div = 0;
        for(int x=1;x<=N;x++){
            div = N/x;
            sum+=div*x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(sumOfDivisors(n));
    }
}
