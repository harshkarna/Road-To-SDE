package com.Array;

public class FindDuplicate1 {

    public static void main(String[] args) {

        int arr[]={0,7,2,5,4,7,1,3,6};
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
               if(arr[i]==arr[j]){
                   count++;
               }
            }
            if(count==2){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
