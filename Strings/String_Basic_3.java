package com.Strings;

import java.util.Scanner;

public class String_Basic_3 {

    public static int get_length(char ch[]){
        int count=0;
        for(int i=0;i<ch.length;i++){
            count++;
        }
        return count;
    }

    public static void reverse_string(char ch[]){
        int i=0;
        int j=ch.length-1;
        while(i<j){
            char temp=ch[j];
            ch[j]=ch[i];
            ch[i]=temp;
            j--;
            i++;
        }

        for (int k = 0; k < ch.length; k++) {
            System.out.print(ch[k]);
        }
    }


    public static void main(String[] args) {

        Scanner s =new Scanner(System.in);
        char[] ch1 = s.next().toCharArray();

        System.out.println(get_length(ch1));
        reverse_string(ch1);

        //Below is the code for converting str to char Array
        String str = "GeeksForGeeks";
        char[] ch = str.toCharArray();


    }
}
