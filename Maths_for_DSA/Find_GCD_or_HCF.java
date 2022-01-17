package com.Maths_for_DSA;

public class Find_GCD_or_HCF {

    //Euclid Theorem

    static int gcf(int a, int b){

        if(a==0){
            return b;
        }
        if (b==0){
            return a;
        }
        while(a!=b){
            if(a>b){
                a=a-b;
            }
            else{
                b=b-a;
            }
        }
        return a;
    }


    public static void main(String[] args) {

        int a=24;
        int b=72;

        System.out.println(gcf(a, b));


    }
}
