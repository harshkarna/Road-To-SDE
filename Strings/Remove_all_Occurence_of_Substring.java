package com.Strings;

public class Remove_all_Occurence_of_Substring {

    public  static void removeOccurrences(String s, String part) {

        int length_part = part.length();
        int start_part = s.indexOf(part);
        int i=1;
        while(start_part>-1){ //or >0
            s =s.substring(0,start_part)+s.substring(start_part+length_part);
            start_part = s.indexOf(part);
        }
        System.out.println(start_part);
        System.out.println(s);

    }
        public static void main(String[] args) {

        String s="daabcbaabcbc";
        String part="abc";
        removeOccurrences(s,part);

    }
}
