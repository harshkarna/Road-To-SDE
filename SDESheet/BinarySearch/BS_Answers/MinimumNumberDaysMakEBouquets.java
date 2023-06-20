/*You are given an integer array bloomDay, an integer m and an integer k.

        You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

        The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

        Return the minimum number of days you need to wait to be able to make m bouquets
        from the garden. If it is impossible to make m bouquets return -1.

        Example 1:

        Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
        Output: 3
        Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
        We need 3 bouquets each should contain 1 flower.
        After day 1: [x, _, _, _, _]   // we can only make one bouquet.
        After day 2: [x, _, _, _, x]   // we can only make two bouquets.
        After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3

        .*/
package com.SDESheet.BinarySearch.BS_Answers;

public class MinimumNumberDaysMakEBouquets {

    public boolean Ispossible(int[] arr, int day,int m, int k) {
        int count=0;
        int noOfBuckets=0;
        for(int i=0; i < arr.length;i++){
            if(arr[i] <= day){
                count++;
            }
            else{
                noOfBuckets+= (count/k);
                count=0;
            }
        }
        noOfBuckets+= (count/k);

        if(noOfBuckets >=m ){
            return true;
        }
        else return false;


    }

    public int minDays(int[] bloomDay, int m, int k) {
        int val=m*k;
        if(val > bloomDay.length) return -1;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        int n =bloomDay.length;
        for(int i : bloomDay){
            maxi=Math.max(maxi,i);
            mini=Math.min(mini,i);
        }

        int low =mini, high=maxi, ans =-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(Ispossible(bloomDay,mid, m,k)){
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
