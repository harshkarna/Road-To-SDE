//    1
//   23
//  456
//78910

package com.Patterns;

public class pattern3 {

    public static void main(String[] args) {

        int n = 4;
        int i = 1;
        int val=1;

        while(i<=n){
            int space =1;
            while (space <=n-i){
                System.out.print(" ");
                space =space+1;
            }
            int j=1;
            while (j<=i){
                System.out.print(val);
                val =val+1;
                j=j+1;
            }
            i=i+1;
            System.out.println();
        }

    }



}
