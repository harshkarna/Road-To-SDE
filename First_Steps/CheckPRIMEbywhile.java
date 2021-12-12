package com.First_Steps;

import java.util.Scanner;

public class CheckPRIMEbywhile {

    public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    long n = sc.nextLong();
    long d=2;
    while(d<n){
        if(n%2==0){
            System.out.println("Not Prime");
            return;
        }
        d=d+1;
    }
        System.out.println("Prime");


    }
}
