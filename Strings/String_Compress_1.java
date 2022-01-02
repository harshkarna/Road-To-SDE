package com.Strings;

public class String_Compress_1 {

    // i was trying to solve this by first converting str to char array
//    but some test cases are passing , so not perfect solution.

    public static void compressString(String str){

        char[] chars=str.toCharArray();
        for(char k:chars){
            System.out.print(k);
        }
        System.out.println();
        String finalString="";

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
            chars[ans_index++]=chars[i];
            //calculate count
            int count=j-i;
            //converting count to char so as to add count in  char array
            if(count >1){
                char[] cnt=Integer.toString(count).toCharArray(); // technique to convert int to char array
                for(char ch: cnt){
                    chars[ans_index++]=ch;
                }
            }
            //moving to new different character
            i=j;
        }
        System.out.println(ans_index);

        //display of array
        for(char k:chars){
            System.out.print(k);
        }
        System.out.println();
        finalString = finalString.valueOf(chars);
        System.out.println(finalString);
    }


    public static void main(String[] args) {

        String str="aabbcdddd";
        compressString(str);

    }


}
