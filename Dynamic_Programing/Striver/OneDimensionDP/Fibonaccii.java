package com.Dynamic_Programing.Striver.OneDimensionDP;


import java.util.*;

public class Fibonaccii {

//    static int f(int n) {
//        //base case
//        if (n <= 1) return n;
//        return f(n - 1) + f(n - 2);
//    }
//
//    public static void main(String args[]) {
//
//        int n = 5;
//        System.out.println(f(n));
//
//    }
//}


    //--Memo
    static int f(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

    public static void main(String args[]) {

        int n = 5;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(n, dp));
        // Print the dp array
        System.out.println("DP Array:");
        for (int i = 0; i <= n; i++) {
            System.out.println("dp[" + i + "] = " + dp[i]);
        }

    }

    public static int calculateFibonacciSpaceOtimised(int n) {
        if (n <= 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(calculateFibonacciSpaceOtimised(n));
//    }
//}

    public static int calculateFibonacciTab(int n) {
        if (n <= 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
}

//    public static void main(String[] args) {
//        int n = 5;
//        System.out.println(calculateFibonacciTab(n));
//    }


