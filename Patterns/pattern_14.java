//         1
//        121
//       12321
//      1234321

package com.Patterns;

import java.util.Scanner;

public class pattern_14 {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        int back_val=0;
        while(i<=n){
            int front_spaces=1;
            while(front_spaces<=n-i){
                System.out.print(" ");
                front_spaces++;
            }

            int j=1;
            int val=1;
            while(j<=i) {
                System.out.print(val);
                val++;
                j++;
            }

                int k=1;
                while(k<i){
                    System.out.print(back_val);
                    k++;
                    back_val--;
                }
              i++;
            back_val=i-1;
            System.out.println();
            }

        }
    }

