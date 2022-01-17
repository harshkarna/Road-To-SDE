package com.Maths_for_DSA;

import java.util.Scanner;

public class basicMaths {


    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }

        for(int i=2;i<n;i++){
            if(n%i==0){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("Plz enter number");
        int toCheck=sc.nextInt();

        if(isPrime(toCheck)){
            System.out.println("Its not a Prime number");

        }
        else
        {
            System.out.println("Its a Prime number");
        }

    }
}
