package com.Strings;

public class String_Compression_LC {
    //populate in same array

    public static void compressString(char[] chars){
        int i=0;
        int n=chars.length;
        int ans_index=0;

        while(i<n){
            int j=i+1;
            while(j<n && chars[i]==chars[j]){
                j++;
            }

            //we will come here when we encounter new element or array is completed

            //old value ko store karalo
            chars[ans_index]=chars[i];
            ans_index++;


            //calculate count
            int count=j-i;


            if(count >1){
                char cnt =(char) count;
                chars[ans_index]=cnt;
                ans_index++;

            }

            //converting count to char so as to add count in  char array
//            if(count >1){
//                char[] cnt=Integer.toString(count).toCharArray(); // technique to convert int to char array
//                for(char ch: cnt){
//                    chars[ans_index]=ch;
//                    ans_index++;
//                }
//            }

            //moving to new different character
            i=j;

        }
        //display of array
        for(int k=0;k < chars.length; k++){
            System.out.print(chars[k]);
        }
    }

    public static void main(String[] args) {

        char[] chars= {'a','a','b','b','c','c','d','d','d','d'};
        compressString(chars);

    }
}
