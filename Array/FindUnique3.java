package com.Array;

public class FindUnique3 {
    //better solution using XOR
    public static void main(String[] args) {

        int arr[]= { 2,4,7,2,7};
        int temp=0;

        for(int i =0;i<arr.length;i++){
            temp=temp^arr[i];
        }
        System.out.println(temp);
    }

}
