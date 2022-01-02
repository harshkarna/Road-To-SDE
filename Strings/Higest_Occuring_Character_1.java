//Highest Occuring Character
//
//        For a given a string(str), find and return the highest occurring character.
//        Example:
//        Input String: "abcdeapapqarr"
//        Expected Output: 'a'
//        Since 'a' has appeared four times in the string which happens to be the highest frequency character,
//        the answer would be 'a'.
//        If there are two characters in the input string with the same frequency, return the character which comes first.
//        Consider:
//        Assume all the characters in the given string to be in lowercase always.
//        Input Format:
//        The first and only line of input contains a string without any leading and trailing spaces.
//        Output Format:
//        The only line of output prints the updated string.
//        Note:
//        You are not required to print anything explicitly. It has already been taken care of.
//        Constraints:
//        0 <= N <= 10^6
//        Where N is the length of the input string.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        abdefgbabfba
//        Sample Output 1:
//        b
//        Sample Input 2:
//        xy
//        Sample Output 2:
//        x


package com.Strings;

public class Higest_Occuring_Character_1 {


    public static void  highestOccChar(String str){
        //creating an array of count of characters
      int arr[]=new int[26];
       for(int i=0;i<str.length();i++){
           char ch =str.charAt(i);
           int n= ch-'a';
           arr[n]++;
       }

       //now getting the max value from last created array
        int max=Integer.MIN_VALUE;// storing frequency
        int ans=Integer.MIN_VALUE;;// storing that value with highest frequency
       for(int i=0;i<arr.length;i++){
           if(arr[i]>max){
               ans=i;
               max=arr[i];
           }
       }

       char finalAnswer= (char) (ans +'a');
        System.out.println(finalAnswer);

    }

    public static void main(String[] args) {

        String str= "test";
        highestOccChar(str);
    }
}
