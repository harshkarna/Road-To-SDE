package com.Recursion.Striver;

public class printNameNtimes {


    public static void printNto1BackTrack( int n){

        if(n < 1){
            return;
        }
        printNto1BackTrack(n-1);
        System.out.println(n);


    }

    public static void main(String[] args) {

        int n =4;
        int i=1;
        printNto1BackTrack(n);


    }
}
