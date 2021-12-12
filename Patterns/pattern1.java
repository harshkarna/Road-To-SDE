//1
//12
//123
//1234
//12345
package com.Patterns;

public class pattern1 {

    public static void main(String[] args) {

        int n =5;
        int i =1;
        while (i<=n){
            int k=1;
            while(k<=i){
                System.out.print(k);
               k++;
            }
            i++;
            System.out.println();
        }
    }
}
