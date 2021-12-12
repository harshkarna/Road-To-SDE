package com.Operators_and_Loops;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int n1=1,n2=1,n3=0,count=10;
//        System.out.print(n1+" "+n2);

        for(int i=2;i<n;i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        System.out.println(n3);


    }
}
