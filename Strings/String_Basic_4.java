package com.Strings;

public class String_Basic_4 {

    public static void main(String[] args) {
        int count=134;
        char[] ch=Integer.toString(count).toCharArray();
        for(int i=0;i<ch.length;i++){
            System.out.println(ch[i]);
        }
         //traversing by for each loop
        for(char cnt :ch){
            System.out.println(cnt);
        }

        String str1="abcdefghi";
        str1=str1.substring(0,3)+str1.substring(5,8);
        System.out.println("ans"+ str1);

    }
}
