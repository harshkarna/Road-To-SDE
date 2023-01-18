/*LCS - Problem

        Given two strings, S and T with lengths M and N, find the length of the 'Longest Common Subsequence'.
        For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same
         relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings
          of length varying from 0 to K.
        Example :
        Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
        Input format :
        The first line of input contains the string S of length M.

        The second line of the input contains the String T of length N.
        Output format :
        Print the length of the 'Longest Common Subsequence'.
        Constraints :
        0 <= M <= 10 ^ 3
        0 <= N <= 10 ^ 3

        Time Limit: 1sec
        Sample Input 1 :
        adebc
        dcadb
        Sample Output 1 :
        3
        Explanation of the Sample Input 1 :
        Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3.
        Sample Input 2 :
        ab
        defg
        Sample Output 2 :
        0
        Explanation of the Sample Input 2 :
        The only subsequence that is common to both the given strings is an empty string("") of length 0.*/
package com.Dynamic_Programing;


public class LongestCommonSubsequence {


    private static int getLongestCommonSubsequence(String str1, String str2, int i , int j) {
        //base case
        if(i >=str1.length() || j >=str2.length()){
            return 0;
        }
        int myAns;
        if(str1.charAt(i)==str2.charAt(j)){
            int smallAns= getLongestCommonSubsequence(str1,str2,i+1,j+1);
            myAns=1+smallAns;
        }
        else{
            int ans1=getLongestCommonSubsequence(str1,str2,i+1,j);
            int ans2=getLongestCommonSubsequence(str1,str2,i,j+1);
            myAns= Math.max(ans1,ans2);
        }
      return myAns;
    }

    private static int getLongestCommonSubsequenceDPR(String str1, String str2, int i, int j, int[][] dp) {

        //base case
        if(i >=str1.length() || j >=str2.length()){
            return 0;
        }
        int myAns;
        if(str1.charAt(i)==str2.charAt(j)){
            int smallAns;
            if(dp[i][j]==-1){
                smallAns= getLongestCommonSubsequence(str1,str2,i+1,j+1);
                dp[i+1][j+1]=smallAns;
            }
            else{
                smallAns=dp[i+1][j+1];
            }
            myAns=1+smallAns;
        }
        else{
            int ans1,ans2;
            if(dp[i+1][j]==-1){
                ans1=getLongestCommonSubsequence(str1,str2,i+1,j);
                dp[i+1][j]=ans1;
            }
            else{
                ans1=dp[i+1][j];
            }
            if(dp[i][j+1]==-1){
                ans2=getLongestCommonSubsequence(str1,str2,i,j+1);
                dp[i][j+1]=ans2;
            }
            else{
                ans2=dp[i][j+1];
            }

            myAns= Math.max(ans1,ans2);
        }
        return myAns;
    }

    private static int getLongestCommonSubsequenceIterative(String str1, String str2) {
        //Bottom up approach
        //base case
        int m=str1.length();
        int n=str2.length();

        //first lets fill the array with infinity
        int[][] dp=new int[m+1][n+1];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int ans;
                if(str1.charAt(i) ==str2.charAt(j)){
                    ans=1+dp[i+1][j+1];
                }
                else{
                    int ans1=dp[i][j+1];
                    int ans2=dp[i+1][j];
                    ans=Math.max(ans1,ans2);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }



    public static void main(String[] args) {
        String str1 = "adebc";
        String str2 = "dcadb";
        System.out.println(getLongestCommonSubsequence(str1,str2,0,0));
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(getLongestCommonSubsequenceDPR(str1,str2,0,0,dp));
        System.out.println(getLongestCommonSubsequenceIterative(str1,str2));
    }



}
