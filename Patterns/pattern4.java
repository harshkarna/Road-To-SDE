//1
//23
//345
//4567


package com.Patterns;

public class pattern4 {


    public static void main(String[] args) {
        int i =1;
        int n =4;
        int val =1;

        while(i<=n){
            int j=1;
            val=i;
            while(j<=i){
                System.out.print(val);
                val=val+1;
                j=j+1;
            }
            i=i+1;
            System.out.println();
        }
    }
}
