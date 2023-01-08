//Stair Case
//
//        A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3
//        steps at a time. Implement a method to count and return all possible ways in which the child
//        can run-up to the stairs.
//        Input format :
//        The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
//        Output format :
//        Print the total possible number of ways.
//        Constraints :
//        0 <= n <= 10 ^ 4
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        4
//        Sample Output 1:
//        7
//        Sample Input 2:
//        10
//        Sample Output 2:
//        274

package com.Dynamic_Programing;

public class StairCase {

    private static int getCountI(int n){
        if(n==1){ //why zero not added
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
         for(int i=4;i<=n;i++){
             dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
         }
         return dp[n];

    }

    private static int getCount(int n, int dp[]){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        int x,y,z;
        if(dp[n-1]==-1){
            x=getCount(n-1,dp);
            dp[n-1]=x;
        }
        else{
            x=dp[n-1];
        }
        if(dp[n-2]==-1){
            y=getCount(n-2,dp);
            dp[n-2]=y;
        }
        else{
            y=dp[n-2];
        }
        if(dp[n-3]==-1){
            z=getCount(n-3,dp);
            dp[n-3]=z;
        }
        else{
            z=dp[n-3];
        }

        return x + y + z;


    }

    public static void main(String[] args) {
        int n= 4;
        int[] dp=new int[n+1];
        for(int i=0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(getCount(n,dp));
        System.out.println(getCountI(4));


    }
}
