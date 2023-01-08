/*
Min Steps To One

        Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to
        get reduced to 1. You can perform any one of the following 3 steps:
        1.) Subtract 1 from it. (n = n - 1) ,
        2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
        3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
        Write brute-force recursive solution for this.
        Input format :
        The first and the only line of input contains an integer value, 'n'.
        Output format :
        Print the minimum number of steps.
        Constraints :
        1 <= n <= 200

        Time Limit: 1 sec
        Sample Input 1 :
        4
        Sample Output 1 :
        2
        Explanation of Sample Output 1 :
        For n = 4
        Step 1 :  n = 4 / 2  = 2
        Step 2 : n = 2 / 2  =  1
        Sample Input 2 :
        7
        Sample Output 2 :
        3
        Explanation of Sample Output 2 :
        For n = 7
        Step 1 :  n = 7 - 1 = 6
        Step 2 : n = 6  / 3 = 2
        Step 3 : n = 2 / 2 = 1

        */

package com.Dynamic_Programing;

public class Min_Steps_to_1 {

    private static int countMinimumStepsToOneIterative(int n){
        if(n==1){
            return 0;
        }
        int[] dp=new int[n+1];
        dp[1]=0;

        for(int i=2;i<=n;i++){
            int subtractOne;
            int divideByTwo=Integer.MAX_VALUE;
            int divideByThree=Integer.MAX_VALUE;

            subtractOne=dp[i-1];
            if(i % 2==0){
                divideByTwo=dp[n/2];
            }

            if(i % 3==0){
                divideByThree=dp[n/3];
            }

            dp[i]= 1 + Math.min(subtractOne,Math.min(divideByThree,divideByTwo));

        }
        return dp[n];

    }

    private static int countMinimumStepsToOne(int n,int[] dp) {
        if (n==1){
            return 0;
        }
        int subtractOne;

        if(dp[n-1]==-1){
            subtractOne=countMinimumStepsToOne(n-1,dp);
            dp[n-1]=subtractOne;
        }
        else{
            subtractOne=dp[n-1];
        }

        int divideByTwo=Integer.MAX_VALUE;

        if(n%2==0){
            if(dp[n/2]==-1){
                divideByTwo=countMinimumStepsToOne(n/2,dp);
                dp[n/2]=divideByTwo;
            }
            else{
                divideByTwo=dp[n/2];
            }
        }

        int divideByThree=Integer.MAX_VALUE;

        if(n%3==0){
            if(dp[n/3]==-1){
                divideByThree=countMinimumStepsToOne(n/3,dp);
                dp[n/3]=divideByThree;
            }
            else{
                divideByThree=dp[n/3];
            }
        }
        return 1+Math.min(subtractOne,Math.min(divideByThree,divideByTwo));

    }


    public static void main(String[] args) {
        int n =4;
        int[] dp=new int[n+1];
        for(int i=0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(countMinimumStepsToOne(n,dp));

        System.out.println(countMinimumStepsToOneIterative(n));
    }

}
