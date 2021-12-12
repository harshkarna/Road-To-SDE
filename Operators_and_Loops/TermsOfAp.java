//Terms of AP
//
//        Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.
//        Input format :
//        Integer x
//        Output format :
//        Terms of series (separated by space)
//        Constraints :
//        1 <= x <= 1,000
//        Sample Input 1 :
//        10
//        Sample Output 1 :
//        5 11 14 17 23 26 29 35 38 41
//        Sample Input 2 :
//        4
//        Sample Output 2 :
//        5 11 14 17


package com.Operators_and_Loops;

import java.util.Scanner;

public class TermsOfAp {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        int n = 1;
        int term=0;
        int count=0;

        while(count<=x){
           term= (3*n)+2;
           if(term % 4==0){
               n++;
               continue;
           }
           else{
               System.out.print(term+ " ");
               count++;
           }
            n=n+1;
        }


    }


}
