//             1
//           23
//         345
//       4567


package com.Patterns;

import java.util.Scanner;

public class pattern5 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
    int i=1;
    int val =1;
    int front_space = (2*n)-2;

    while(i<=n){

        int k =1;
        while(k<=front_space){
            System.out.print(" ");
            k=k+1;
        }
        int j=1;
        val=i;
        while (j<=i) {
            System.out.print(val);
            val = val + 1;
            j = j + 1;

        }

        //Not Required
//        int back_space =1;
//        while(back_space< i){
//            System.out.print(" ");
//            back_space =back_space+1;
//           }

        i=i+1;
        front_space= front_space-2;
        System.out.println();

     }

    }
}
