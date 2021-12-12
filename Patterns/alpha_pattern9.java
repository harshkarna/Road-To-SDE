//Code : Interesting Alphabets
//
//        Print the following pattern for the given number of rows.
//        Pattern for N = 5
//        E
//        DE
//        CDE
//        BCDE
//        ABCDE
//        Input format :
//        N (Total no. of rows)
//        Output format :
//        Pattern in N lines
//        Constraints
//        0 <= N <= 26
//        Sample Input 1:
//        8
//        Sample Output 1:
//        H
//        GH
//        FGH
//        EFGH
//        DEFGH
//        CDEFGH
//        BCDEFGH
//        ABCDEFGH
//        Sample Input 2:
//        7
//        Sample Output 2:
//        G
//        FG
//        EFG
//        DEFG
//        CDEFG
//        BCDEFG
//        ABCDEFG




package com.Patterns;

import java.util.Scanner;

public class alpha_pattern9 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        char starting_char=(char)('E');
        while(i<=n){
            int j=1;
            while(j<=i){
                System.out.print((char)(starting_char+j-1));
                j++;
            }
            starting_char--;
            i++;
            System.out.println();
        }
    }

}
