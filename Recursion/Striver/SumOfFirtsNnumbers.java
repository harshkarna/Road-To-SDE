package com.Recursion.Striver;

public class SumOfFirtsNnumbers {


    public static  int  Sum(int n){

        if(n==0 ){
            return n;
        }
        return n + Sum(n-1);

    }

    public static  int  fact(int n){

        if(n==1 ){
            return 1;
        }
        return n * fact(n-1);

    }




    public static void main(String[] args) {
        int n =10;
        System.out.println(Sum(10));
        System.out.println(fact(4));


    }
}
