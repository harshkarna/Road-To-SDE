//    *
//   **
//  ***
// ****

package com.Patterns;

import java.util.Scanner;

public class star_pattern10 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;

        while(i<=n){
            int front_spaces=1;
            while(front_spaces<=n-i){
                System.out.print(" ");
                front_spaces++;
            }
            int j=1;
            while(j<=i){
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }


    }
}
