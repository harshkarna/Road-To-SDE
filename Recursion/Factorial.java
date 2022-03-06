package com.Recursion;

public class Factorial {

    public static int fact(int n){

        if (n==0){   //  Taking Base case
            return 1;
        }
        int smallcase=fact(n-1);
        return n* smallcase;
    }


    public static void main(String[] args) {

        int n =3;
        int ans =fact(n);
        System.out.println(ans);
    }
}
