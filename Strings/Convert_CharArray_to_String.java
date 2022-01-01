package com.Strings;

public class Convert_CharArray_to_String {


    public static String toString(char[] a)
    {
        // Creating object of String class
        String string = new String(a);

        return string;
    }

    // Main driver method
    public static void main(String args[])
    {
        // Character array
        char s[] = { 'h','a','r','s','h' };

        // Printing converted string from character array
        System.out.println(toString(s));
    }



}
