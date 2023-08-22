package com.Dynamic_Programing.Striver.OneDimensionDP;

import java.util.Arrays;

public class FrogJumpwithKDistance {

//    public static int frogJumpRecur(int index, int heights[]) {
//        //base case
//        if(index==0){
//            return 0;
//        }
//        //Calculating first step and rest job recusrion will do
//        int OneJump = Math.abs(heights[index]-heights[index-1])+ frogJumpRecur(index-1, heights) ;
//        int TwoJump=Integer.MAX_VALUE;
//        if(index> 1){
//            //as if its 1 step only then going -2 doesn't make sense
//            TwoJump= Math.abs(heights[index]-heights[index-2])+ frogJumpRecur(index-2, heights) ;
//        }
//        return Math.min(OneJump, TwoJump);
//
//    }

    public static int frogJumpRecur(int index, int heights[], int k ) {
        //base case
        if(index==0){
            return 0;
        }
        int minsSteps =Integer.MAX_VALUE;
        for(int j =1; j <=k;j++){
            if(index-j>0){
                int jumpEnergy= Math.abs(heights[index]-heights[index-j])+ frogJumpRecur(index-j, heights, k );
                minsSteps=Math.min(minsSteps,jumpEnergy);
            }

        }
        return minsSteps;

    }

    public static int frogJumpRec(int n, int heights[], int k) {
        //base case
        return frogJumpRecur(n-1,heights,k);

    }


    static int frogJumpMemo(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = frogJumpMemo(ind-j, height, dp, k)+ Math.abs(height[ind]- height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;

    }

    static int frogJumpMemo(int n, int[] height , int k){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return frogJumpTab(n-1, height, dp, k);
    }


    static int frogJumpTab(int n, int[] height, int[] dp, int k){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmSteps = Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+ Math.abs(height[i]- height[i-j]);
                    mmSteps= Math.min(jump, mmSteps);
                }
            }
            dp[i]= mmSteps;
        }
        return dp[n-1];

    }


    static int frogJumpTab(int n, int[] height , int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return frogJumpTab(n, height, dp, k);
    }
    public static void main(String[] args) {


    }
}
