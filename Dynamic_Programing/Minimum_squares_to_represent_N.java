/*
Minimum Number Of Squares

        Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
        That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
        The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
        Input format :
        The first and the only line of input contains an integer value, 'N'.
        Output format :
        Print the minimum count of numbers required.
        Constraints :
        0 <= n <= 10 ^ 4

        Time Limit: 1 sec
        Sample Input 1 :
        12
        Sample Output 1 :
        3
        Explanation of Sample Output 1 :
        12 can be represented as :
        A) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)

        B) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)  + (2 ^ 2)

        C) (1^1) + (1^1) + (1^1) + (1^1) + (2 ^ 2) + (2 ^ 2)

        D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

        As we can see, the output should be 3.
        Sample Input 2 :
        9
        Sample Output 2 :
        1
*/

package com.Dynamic_Programing;

public class Minimum_squares_to_represent_N {
/*

    Recursive approach

    public static int minSquares(int n){
        if(n==0){
            return 0;
        }

        int minAns=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currAns=minSquares(n-(i*i));
            if(currAns < minAns){
                minAns=currAns;
            }
        }
        int myAns=1+minAns;
        return myAns;
    }
*/


    //Recursive DP
    public static int minSquares(int n, int[] dp){
        if(n==0){
            return 0;
        }

        int minAns=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currAns;
            if(dp[n-(i*i)]==-1){
                currAns=minSquares(n-(i*i),dp);
                dp[n-(i*i)]=currAns;
            }
            else{
                currAns=dp[n-(i*i)];
            }

            if(currAns < minAns){
                minAns=currAns;
            }
        }
        int myAns=1+minAns;
        return myAns;
    }


    //Iterative DP
    public static int minSquaresI(int n){
        int[] dp=new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int minAns=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int currAns;
                if(dp[i-(j*j)]==-1){
                    currAns=minSquaresI(i-(j*j));
                    dp[i-(j*j)]=currAns;
                }
                else{
                    currAns=dp[i-(j*j)];
                }

                if(currAns < minAns){
                    minAns=currAns;
                }
            }
            dp[i]=1+minAns;
        }

        return dp[n];
    }



    public static void main(String[] args) {
        int n =41;
        int[] dp=new int[n+1];
        for(int i=0 ;i <dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(minSquares(n,dp));
        System.out.println(minSquaresI(n));


    }
}
