//Input : int arr[]={3,3} , sum =6
//Output : [0,1]

package com.Array;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int arr[]=new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){

                if( (nums[i] + nums[j] ) == target){
                        arr[0]=i;
                        arr[1]=j;

                    }
                }
            }
        //display of array
        for(int i=0;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        return arr;

        }

    public static void main(String[] args) {
        int arr[]={3,3};
        twoSum(arr,6);
    }
    }
