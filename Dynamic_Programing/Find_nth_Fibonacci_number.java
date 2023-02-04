package com.Dynamic_Programing;

public class Find_nth_Fibonacci_number {

//    Iterative way to solve
      public static int fibbI(int n){
          if(n==0 || n==1){
              return n;
          }
          int[] dp=new int[n+1];
          //store base cases here
          dp[0]=0;
          dp[1]=1;
          //now start from 2 till n
          for(int i=2;i<=n;i++){
              dp[i]=dp[i-1]+dp[i-2];
          }

          return dp[n];

      }

      //2nd Approach below

/*    This process is called memoization = Recursion + storing
       Here for storing calls we are using array

    */

    private static int getFibb(int n,int dp[]) {
        if(n==0 || n==1){
            return n;
        }
        int ans1 , ans2;
        if(dp[n-1]==-1){
            ans1=getFibb(n-1,dp);
            dp[n-1]=ans1;
        }
        else{
            ans1=dp[n-1];
        }

        if(dp[n-2]==-1){
            ans2=getFibb(n-2,dp);
            dp[n-2]=ans2;

        }
        else{
            ans2=dp[n-2];
        }

        int myAns= ans1+ans2;
        return myAns;

        }

     public static int memo(int n, int dp[]){
        if(n==1 || n==0)return n;
        if(dp[n]!=-1)return dp[n];
        dp[n]=memo(n-1,dp) + memo(n-2,dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n=10;
        int[] dp=new int[n+1];
        for(int i=0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        int ans=getFibb(n, dp);
        System.out.println(memo(10,dp));
        System.out.println(fibbI(10));
    }

}
