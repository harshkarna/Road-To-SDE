package com.Recursion.Striver;

public class Staircase {
    public static int staircase(int n){
        if(n==0 || n==1){
            return 1;
        }

        return staircase(n-2)+staircase(n-1);

    }

    public static void main(String[] args) {
        int n =4;
        System.out.println(staircase(n));


    }

}
