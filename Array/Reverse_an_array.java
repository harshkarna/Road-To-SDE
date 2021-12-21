package com.Array;

public class Reverse_An_Array {

    public static int[] reverse(int arr[]){
        int s=0;
        int e= arr.length-1;
        int temp=0;
        while(s<e){
            temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        return arr;
    }

    public static void main(String[] args) {

        int arr[]={1,2,3,8,4,5,6};
        reverse(arr);
        //display of array
        for(int i=0;i <arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
