package com.Strings;

public class StringPool {

    //https://www.javatpoint.com/string-pool-in-java#:~:text=String%20pool%20is%20nothing%20but,by%20the%20Java%20String%20class.

    public static void main(String[] args) {
        String str="abc";//stored in stringpool within heap
        String str1="abc";//stored in stringpool within heap
        String str2 =new String("abc");//stored in heap directly
        String str3="abc";//stored in stringpool within heap

        if(str1==str2){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }


//        System.out.println(str1.equals(str2));

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);


    }
}
