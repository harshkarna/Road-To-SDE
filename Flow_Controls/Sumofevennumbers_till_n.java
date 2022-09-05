//Sum of Even Numbers till N
//
//        Given a number N, print sum of all even numbers from 1 to N.
//        Input Format :
//        Integer N
//        Output Format :
//        Required Sum
//        Sample Input 1 :
//        6
//        Sample Output 1 :
//        12
//


package com.Flow_Controls;

import java.util.Scanner;

public class Sumofevennumbers_till_n {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int i =0;
        long sum=0;
        while(i<=n){
            sum = sum+i;
            i=i+2;
        }
        System.out.println(sum);
    }

}
