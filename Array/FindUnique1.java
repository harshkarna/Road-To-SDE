package com.Array;

public class FindUnique1 {

    public static void main(String[] args) {

        int arr[]= { 2,4,7,2,7};

        for(int i =0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count==1){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}

