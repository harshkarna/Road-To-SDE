package com.Maths_for_DSA;

import java.util.Scanner;

public class Count_Prime {

    public static int countPrimes(int n){

        boolean prime[] = new boolean[n];
        for(int i=2 ; i<n ; i++){
            prime[i] = true;
        }
        int cnt = 0;
        for(int i=2 ; i<n ; i++){
            if(prime[i]){
                cnt++;
                for(int j = 2*i ; j<n ; j=j+i){
                    prime[j] = false;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int n=20;
        System.out.println(countPrimes(n));
    }
}
