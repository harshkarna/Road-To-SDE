/*Smallest Super-Sequence

        Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
        The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the
         given strings as its subsequences.
        Note :
        If the two strings do not have any common characters, then return the sum of the lengths of the two strings.
        Input Format:
        The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T.
        Output Format:
        Length of the smallest super-sequence of given two strings.
        Constraints :
        0 <= M <= 10 ^ 3
        0 <= N <= 10 ^ 3

        Time Limit: 1 sec
        Sample Input 1 :
        ab
        ac
        Sample Output 1 :
        3
        Explanation of Sample Output 1 :
        Their smallest super sequence can be "abc" which has length = 3.
        Sample Input 2 :
        pqqrpt
        qerepct
        Sample Output 2 :
        9
        */
package com.Dynamic_Programing;

public class SmallestSuperSequence {

    public static void print2DArray(int[][] arr){
        //display 2D Array
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int getShortestCommonSubsequenceIterative(String str1, String str2) {
        //Bottom up approach
        //base case
        int m=str1.length();//2
        int n=str2.length();//3

        //first lets fill the array with zeroes
        int[][] dp=new int[m+1][n+1]; // 3 , 4
        int k=0;
        int l=0;
        //fling rows
        for(int i=m;i>=0;i--){
            dp[i][n]=k;
            k++;
        }
        //filing columns
        for(int j=n;j>=0;j--){
            dp[m][j]=l;
            l++;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int ans;
                if(str1.charAt(i) ==str2.charAt(j)){
                    ans=1+dp[i+1][j+1];
                }
                else{
                    int ans1=dp[i][j+1];
                    int ans2=dp[i+1][j];
                    ans= 1+ Math.min(ans1,ans2);
                }
                dp[i][j]=ans;
            }
        }
        print2DArray(dp);
        return dp[0][0];
    }


    public static void main(String[] args) {

        String str1 = "ac";
        String str2 = "abd";
        System.out.println(getShortestCommonSubsequenceIterative(str1,str2));
    }

}
