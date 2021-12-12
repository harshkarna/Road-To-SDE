package com.Array;

public class PairSum1 {

    public static void main(String[] args) {

//        int arr[]={2,8,10,5,-2,5};
        int arr[]={1,3,6,2,5,4,3,2,4};
        int sum=7;

        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println("(" +arr[i]+ "," +arr[j]+ ")");
                }
            }
        }

    }
}
