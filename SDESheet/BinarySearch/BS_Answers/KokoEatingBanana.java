/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 The guards have gone and will come back in h hours.

       Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of
       bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all
       of them instead and will not eat any more bananas during this hour.

       Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

       Return the minimum integer k such that she can eat all the bananas within h hours.


        Example 1:

        Input: piles = [3,6,7,11], h = 8
        Output: 4
        Example 2:

        Input: piles = [30,11,23,4,20], h = 5
        Output: 30*/

package com.SDESheet.BinarySearch.BS_Answers;

public class KokoEatingBanana {
    private static int findMax(int[] piles) {
       int maxi=Integer.MIN_VALUE;
       int n =piles.length;
       for(int i : piles){
           maxi=Math.max(maxi,i);
       }
       return maxi;
    }

    private static int calculateTotalHours(int[] piles, int hourly) {
       int totalH=0;
       int n = piles.length;
       for(int i=0; i <n ;i++){
           totalH +=Math.ceil((double)piles[i]/(double) hourly);
       }
       return totalH;
    }
    public  static int  minEatingSpeed(int[] piles, int h) {
        int low =1, high=findMax(piles);
        int ans=-1;
        while(low<=high){
            int mid =(low+high)/2;
            int totalH=calculateTotalHours(piles,mid);
            if(totalH <=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }




    public static void main(String[] args) {

    }
}
