package com.SDESheet.BinarySearch.BS_Answers;

import java.util.Arrays;

public class AggressiveCows {

    private static boolean canWePlace(int[] stalls, int distance, int cows) {
      int cntCows=1,lastStall=stalls[0];
      for(int i=0; i < stalls.length;i++){
          if(stalls[i]-lastStall >= distance){
              cntCows++;
              lastStall=stalls[i];
          }
          if(cntCows>=cows) return true;
      }
      return false;
    }


    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low=1,high=stalls[n-1]-stalls[0], ans=n;
        while(low <=high){
            int mid = (low+high)/2;
            if(canWePlace(stalls,mid, k )==true){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }




    public static void main(String[] args) {


    }
}
