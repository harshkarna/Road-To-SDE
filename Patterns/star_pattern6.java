//    *
//   ***
//  *****
// *******


package com.Patterns;
import java.util.Scanner;

public class star_pattern6 {

    public static void main(String[] args) {

    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
//    int n =4;

        long start = System.currentTimeMillis();
        int i=1;
    while(i<=n){
        int front_space = 1;
        while(front_space<=n-i){
            System.out.print(" ");
            front_space=front_space+1;
        }

        int j=1;
        while(j<=(2*i)-1){
            System.out.print("*");
            j=j+1;
        }


//       //Not required
//        int back_space = 1;
//        while(back_space<=n-i){
//            System.out.print(" ");
//            back_space=back_space+1;
//        }

        i=i+1;
        System.out.println();
        }

        System.out.println(System.currentTimeMillis() - start);
    }


}
