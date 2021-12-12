package com.First_Steps;

import java.util.Scanner;

public class AllPrimefunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                System.out.println(2);
            }
            else if (checkprime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean checkprime(int n ){
        for (int i = 2; i < n; i++) {
            if(n % i == 0 ) {
                return false;
            }
        }
        return true;
    }

}

