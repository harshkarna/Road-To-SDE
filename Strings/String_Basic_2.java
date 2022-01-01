package com.Strings;

import java.util.Scanner;

public class String_Basic_2 {

    public static void main(String[] args) {
//        char ch[]=new char[10];

        Scanner s =new Scanner(System.in);
        char[] a = s.next().toCharArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
