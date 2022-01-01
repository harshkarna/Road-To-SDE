//Compress the String
//
//        Write a program to do basic string compression. For a character which is consecutively
//        repeated more than once, replace consecutive duplicate occurrences with the count of repetitions.
//        Exmple:
//        If a string has 'x' repeated 5 times, replace this "xxxxx" with "x5".
//
//        The string is compressed only when the repeated character count is more than 1.
//        Note :
//        Consecutive count of every character in the input string is less than or equal to 9.
//        Input Format:
//        The first and only line of input contains a string without any leading and trailing spaces.
//        Output Format:
//        The only line of output prints the updated string.
//        Note:
//        You are not required to print anything. It has already been taken care of.
//        Constraints:
//        0 <= N <= 10^6
//        Where N is the length of the input string.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        aaabbccdsa
//        Sample Output 1:
//        a3b2c2dsa
//        Sample Input 2:
//        aaabbcddeeeee
//        Sample Output 2:
//        a3b2cd2e5

package com.Strings;

public class Compress_String {
    public static void CompressString(String str){
        int count=1;
        String ans="";
        int i;
        for(i=1;i<str.length();i++){
            //we will check when at i , is not same as i-1
            if(str.charAt(i)!=str.charAt(i-1)){
                String previous=str.substring(i-1,i);
                //handing when count of element is only 1
                if(count==1){
                    ans=ans+previous;
                    count=1;// not required
                    continue;
                }
                else{
                    ans=ans+previous+count;
                    count=1;
                    continue;
                }
            }
            count++;
        }
        // for last group of elemnent
        if(count==1){
            ans=ans+str.substring(i-1,i);
        }
        else{
            ans=ans+str.substring(i-1,i)+count;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        String str= "aaabbcddeeeee";
        CompressString(str);
    }


}
