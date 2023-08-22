/*
Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair.
        At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the
        frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]),
        where abs() means the absolute difference. We need to return the minimum energy that can be used by the
        frog to jump from stair 0 to stair N-1.
*/


package com.Dynamic_Programing.Striver.OneDimensionDP;

import java.util.ArrayList;
import java.util.Arrays;

public class FrogJump {


    public static int frogJumpRecur(int index, int heights[]) {
       //base case
        if(index==0){
            return 0;
        }
        //Calculating first step and rest job recusrion will do
        int OneJump = Math.abs(heights[index]-heights[index-1])+ frogJumpRecur(index-1, heights) ;
        int TwoJump=Integer.MAX_VALUE;
        if(index> 1){
            //as if its 1 step only then going -2 doesn't make sense
            TwoJump= Math.abs(heights[index]-heights[index-2])+ frogJumpRecur(index-2, heights) ;
        }
        return Math.min(OneJump, TwoJump);

    }

    public static int frogJumpRec(int n, int heights[]) {
        //base case
        return frogJumpRecur(n-1,heights);

    }


    public static int frogJumpMemo(int index, int heights[], int[] dp) {
        //base case
        if(index==0){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];
        //Calculating first step and rest job recusrion will do
        int OneJump = Math.abs(heights[index]-heights[index-1])+ frogJumpMemo(index-1, heights,dp) ;
        int TwoJump=Integer.MAX_VALUE;
        if(index> 1){
            //as if its 1 step only then going -2 doesn't make sense
            TwoJump= Math.abs(heights[index]-heights[index-2])+ frogJumpMemo(index-2, heights,dp) ;
        }
        return  dp[index]=Math.min(OneJump, TwoJump);

    }

    public static int frogJumpM(int n, int heights[]) {
        //base case
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return frogJumpMemo(n-1,heights,dp);

    }


    public static int frogJumpTab(int n, int heights[]) {
        //base case
        int[] dp=new int[n]; //you can take n+1 also, the at last you need to return n instead of n-1
        dp[0]=0;//base case
        for(int i=1; i < n ;i++){
            int OneJump = Math.abs(heights[i]-heights[i-1])+ dp[i-1] ;
            int TwoJump=Integer.MAX_VALUE;
            if(i> 1){
                //as if its 1 step only then going -2 doesn't make sense
                TwoJump= Math.abs(heights[i]-heights[i-2])+ dp[i-2] ;
            }
            dp[i]=Math.min(OneJump,TwoJump);
        }
        //return n-1 (last index) if dp array for n size
        return dp[n-1];

    }


    public static int frogJumpSpacOptimise(int n, int heights[]) {
        //base case
        int prev=0;
        int prev2=0;
        for(int i=1; i < n ;i++){
            int OneJump = Math.abs(heights[i]-heights[i-1])+ prev ;
            int TwoJump=Integer.MAX_VALUE;
            if(i> 1){
                //as if its 1 step only then going -2 doesn't make sense
                TwoJump= Math.abs(heights[i]-heights[i-2])+ prev2 ;
            }
           int current=Math.min(OneJump,TwoJump);
            prev2=prev;
            prev=current;
        }
        //return n-1 (last index) if dp array for n size
        return prev;

    }


    public static void main(String[] args) {


    }
}
