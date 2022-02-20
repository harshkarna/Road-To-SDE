package com.Strings;

import sun.lwawt.macosx.CSystemTray;

public class StringBuilder_Basics {

    public static void main(String[] args) {

        String str="Harsh";
        StringBuilder sb =new StringBuilder(str);
        System.out.println(sb);

        //to get char at index
        System.out.println(sb.charAt(0));

//        to set char at partcluar index
        sb.setCharAt(0,'P');
        System.out.println(sb);

        //to insert a char at index
        sb.insert(0,'S');
        System.out.println(sb);

//        //delete
        sb.delete(0,1);
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
//
//        //append
        sb.append("String");
        System.out.println(sb);
        sb.append('a');
        System.out.println(sb);
//
//        //replace
        sb.replace(0,1,"@40");
        System.out.println(sb);


    }
}
