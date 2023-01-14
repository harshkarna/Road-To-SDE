/*
Coin Tower

        Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns.
         Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower.
          The person to make the last move wins the game. Can you find out who wins the game?
        Input format :
        The first and the only line of input contains three integer values separated by a single space.
        They denote the value of N, X and Y, respectively.
        Output format :
        Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).
        Constraints :
        1 <= N <= 10 ^ 6
        2 <= X <= Y<= 50

        Time Limit: 1 sec
        Sample Input 1 :
        4 2 3
        Sample Output 1 :
        Whis
        Sample Input 2 :
        10 2 4
        Sample Output 2 :
        Beerus


        Link - https://www.youtube.com/watch?v=pDr7wDufgVc
*/


/*
//Approach ;
a will win when i :-
        1.a loses for n-1 coins OR
        2.a loses for n-x coins OR
        3.a loses for n-y coins Then if either of above is true then

        a will win for n coins otherwise it will loose
*/


package com.Dynamic_Programing;

public class Coin_Tower {

    private static String getWinner(int n, int x, int y) {
        boolean[] dp=new boolean[n+1];
        dp[0]=false;
        dp[1]=true;

        for(int i=2;i<=n;i++){
            if(i-1>=0 && dp[i-1]==false){
                dp[i]=true;
            }
            else if(i-x>=0 && dp[i-x]==false){
                dp[i]=true;
            }
            else if(i-y>=0 && dp[i-y]==false){
                dp[i]=true;
            }
            else{
                dp[i]=false;
            }

        }
        if(dp[n]){
            return "Beerus";
        }
        else{
            return "Whis";
        }

    }

    public static void main(String[] args) {
      int coins=4;
      int x=2;
      int y=3;
      System.out.println(getWinner(coins,x,y));

    }

}
