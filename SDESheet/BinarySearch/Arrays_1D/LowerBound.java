package com.SDESheet.BinarySearch.Arrays_1D;

public class LowerBound {

   //  what is lower bound - > smallest index such that arr[index] > = x where x is the target

    //TO(log base2 N) same as binary search

    public static int lowerBound(int []arr, int n, int x) {
       int low=0;
       int high =n-1;
       //by default if nothing is found
       int ans=n;

       while (low <=high){
           int mid =(low+high)/2;
           //may be an answer, on left side , so store mid in ans and move high to mid-1
           if(arr[mid] >= x){
               ans=mid ;
               //look for more smallest index on left
               high =mid-1;
           }
           else {
               low=mid+1;// look for right
           }
       }
       return ans;

    }



    public static void main(String[] args) {


    }
}
