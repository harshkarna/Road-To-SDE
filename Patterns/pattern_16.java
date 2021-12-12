//    *
//   ***
//  *****
//   ***
//    *


package com.Patterns;

import java.util.Scanner;

public class pattern_16 {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int i=1;
        int m=n-2;
        while(i<= (n/2)+1){
            int frontspaces=1;
            while(frontspaces<=((n/2)+1-i)){
                System.out.print(" ");
                frontspaces++;

            }
             int j=1;
             while(j<=(2*i)-1){
                 System.out.print("*");
                 j++;
             }

            i++;
            System.out.println();

            }

        int k=n/2+2;
        while(k<=n){
            int lower_frontspaces=1;
            while(lower_frontspaces<=k-((n/2)+1)){

                System.out.print(" ");
                lower_frontspaces++;
            }
           int lower_stars=1;
            while(lower_stars<=m){
                System.out.print("*");
                lower_stars++;
            }

            k++;
            m=m-2;
            System.out.println();
        }

        }

    }

