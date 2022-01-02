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

            //old value ko store karalo
            chars[ans_index]=chars[i];
            ans_index++;

            int count=j-i;

            //convert count to char
            if(count >1){
                char[] cnt=Integer.toString(count).toCharArray();
                for(char ch: cnt){
                    chars[ans_index]=ch;
                    ans_index++;
                }
            }
            i=j;

        }
        //display of array
        for(int k=0;k < chars.length; k++){
            System.out.print(chars[k]);
        }
    }

    public static void main(String[] args) {

        char[] chars= {'a','a','b','b','c','c','d'};
        compressString(chars);

    }
}
