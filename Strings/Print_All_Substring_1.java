package com.Strings;

import java.util.Scanner;

public class Print_All_Substring_1 {


    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
//        String str=s.nextLine();
        String str="pqrs";


        for(int i =0;i<str.length();i++){
            int k=i;
            for(int j=0;j<str.length()-i;j++){
                System.out.println(str.substring(j,k+1));
                k++;
            }
        }

    }
}
