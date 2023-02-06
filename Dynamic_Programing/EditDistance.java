/*Edit Distance

        You are given two strings S and T of lengths M and N, respectively.
        Find the 'Edit Distance' between the strings.
        Edit Distance of two strings is the minimum number of steps required to make one string
         equal to the other. In order to do so, you can perform the following three operations:
        1. Delete a character
        2. Replace a character with another one
        3. Insert a character
        Note :
        Strings don't contain spaces in between.
        Input format :
        The first line of input contains the string S of length M.

        The second line of the input contains the String T of length N.
        Output format :
        Print the minimum 'Edit Distance' between the strings.
        Constraints :
        0 <= M <= 10 ^ 3
        0 <= N <= 10 ^ 3

        Time Limit: 1 sec
        Sample Input 1 :
        abc
        dc
        Sample Output 1 :
        2
        Explanation to the Sample Input 1 :
        In 2 operations we can make string T to look like string S.
        First, insert character 'a' to string T, which makes it "adc".

        And secondly, replace the character 'd' of string T with 'b' from the string S.
        This would make string T as "abc" which is also string S.

        Hence, the minimum distance.
        Sample Input 2 :
        whgtdwhgtdg
        aswcfg
        Sample Output 2 :
        9
        */
package com.Dynamic_Programing;


public class EditDistance {

    private static int getEditDistance(String str1, String str2, int i, int j) {
        //Base case
        if(i==str1.length()){
            return str2.length()-j;
        }

        if(j==str2.length()){
            return str1.length()-i;
        }

        int myAns;
        if(str1.charAt(i)==str2.charAt(j)){
            myAns=getEditDistance(str1,str2,i+1,j+1);
        }
        else{
            int ans1= 1+ getEditDistance(str1,str2, i+1,j+1); //replace
            int ans2= 1 + getEditDistance(str1,str2,i+1,j); // delete
            int ans3= 1 + getEditDistance(str1,str2,i,j+1);// insert
            myAns= Math.min(ans1,Math.min(ans2,ans3));
        }
        return myAns;

    }

    private static int getEditDistanceMemo(String str1, String str2, int i, int j, int[][] dp) {
        //Base case
        if(i==str1.length()){
            return str2.length()-j;
        }

        if(j==str2.length()){
            return str1.length()-i;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(str1.charAt(i)==str2.charAt(j)){
            dp[i][j]=getEditDistanceMemo(str1,str2,i+1,j+1,dp);
        }
        else{
            int ans1= 1+ getEditDistanceMemo(str1,str2, i+1,j+1,dp); //replace
            int ans2= 1 + getEditDistanceMemo(str1,str2,i+1,j,dp); // delete
            int ans3= 1 + getEditDistanceMemo(str1,str2,i,j+1,dp);// insert
            dp[i][j]= Math.min(ans1,Math.min(ans2,ans3));
        }
        return dp[i][j];

    }

    //Not working

    private static int getEditDistanceDPR(String str1, String str2, int i, int j, int[][] dp) {
        //Base case
        if(i==str1.length()){
            return str2.length()-j;
        }

        if(j==str2.length()){
            return str1.length()-i;
        }

        int myAns;
        if(str1.charAt(i)==str2.charAt(j)){
            if(dp[i][j]==-1){
                myAns=getEditDistanceDPR(str1,str2,i+1,j+1,dp);
                dp[i+1][j+1]=myAns;
            }
            else{
                myAns=dp[i+1][j+1];
            }
        }
        else{
            int ans1,ans2,ans3;
            if(dp[i+1][j+1]==-1){//replace
                ans1= getEditDistanceDPR(str1,str2, i+1,j+1,dp);
                dp[i+1][j+1]=ans1;
            }
            else{
                ans1=dp[i+1][j+1];
            }

            if(dp[i+1][j]==-1){//replace
                ans2= getEditDistanceDPR(str1,str2, i+1,j,dp);
                dp[i+1][j]=ans2;
            }
            else{
                ans2=dp[i+1][j];
            }


            if(dp[i][j+1]==-1){//replace
                ans3= getEditDistanceDPR(str1,str2, i,j+1,dp);
                dp[i][j+1]=ans3;
            }
            else{
                ans3=dp[i][j+1];
            }

            myAns= 1 + Math.min(ans1,Math.min(ans2,ans3));
        }
        return myAns;

    }

    //Not done
    private static int getEditDistanceIterative(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();

        //first lets fill the array with infinity
        int[][] dp=new int[m+1][n+1];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int ans;
                if(str1.charAt(i) ==str2.charAt(j)){
                    ans=dp[i+1][j+1];
                }
                else{
                    int ans1=dp[i+1][j+1];
                    int ans2=dp[i+1][j];
                    int ans3=dp[i][j+1];
                    ans=Math.min(ans1,Math.min(ans2,ans3));
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];

    }



    public static void main(String[] args) {
        String str1 = "teacher";
        String str2 = "acheer";
        System.out.println(getEditDistance(str1,str2,0,0));
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(getEditDistanceDPR(str1,str2,0,0,dp));
        System.out.println(getEditDistanceMemo(str1,str2,0,0,dp));
        System.out.println(getEditDistanceIterative(str1,str2));


    }


}
