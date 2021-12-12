//Code : Triangle of Numbers
//

//           1
//         232
//       34543
//     4567654
//   567898765



package com.Patterns;

import java.util.Scanner;

public class pattern_15 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();

        int i=1;
        int middle_val=2;
        int back_val=1;
        while(i<=n){
            int front_spaces=1;
            while(front_spaces<=2*(n-i)){
                System.out.print(" ");
                front_spaces++;
            }

            int j=1;
            while(j<i){
                System.out.print(middle_val);
                j++;
                middle_val++;
            }

            int k=1;
            while(k<=i){
                System.out.print(back_val);
                back_val--;
                k++;
            }

            i++;
            middle_val=i;
            back_val=(2*i)-1;
            System.out.println();
        }

    }
}
