package com.SDESheet.Arrays.Easy;

public class Largest_Element_in_Array {

    public int largest(int arr[], int n)
    {
        int max =Integer.MIN_VALUE;
        for(int i=0;i < arr.length;i++){
            if(arr[i] > max){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
