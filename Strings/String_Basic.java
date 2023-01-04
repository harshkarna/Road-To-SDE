package com.Strings;

import java.util.Scanner;

public class String_Basic {


    public static void main(String[] args) {
        char arr[]={'c','o','d','i','n','g'};
        String str ="Coding";
        System.out.println(str.length()); // to get length
        System.out.println(str.charAt(2)); //to access particular index element

        String str1 ="Codingiunh";
        String str2 =" is Fun back ";
        String str3 ="Cmod";
//
//        String[] arr1=str2.split(" ");
//        for(String i :arr1){
//            System.out.print(i +" ");
//        }



        System.out.println(str1+str2); //to concatenate

        String str4=str1.concat(str2);
        System.out.println(str4); //to concatenate

        System.out.println(str1.equals(str2)); // return boolean , if str1 & str2 exactly equal then true

        System.out.println(str1.compareTo(str3)); //compareTo

//   The compareTo() method compares two strings lexicographically.
//   The comparison is based on the Unicode value of each character in the strings.
//   The method returns 0 if the string is equal to the other string. A value less than 0 is
//   returned if the string is less than the other string (less characters) and a value greater than 0 if the string
//   is greater than the other string (more characters).


        System.out.println(str1.substring(2));// start from index 2
        System.out.println(str1.substring(1,6));// start from index 1(inclusve ),5 (exclusive)

//        Scanner s=new Scanner(System.in);
//        str =s.nextLine();
//        str1=s.nextLine();
//        System.out.println(str +" "+str.length());
//        System.out.println(str1 +" "+str1.length());
//        //https://www.javaartifacts.com/difference-next-nextline/



    }

}
