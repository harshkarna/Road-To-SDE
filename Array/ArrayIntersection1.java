package com.Array;

public class ArrayIntersection1 {


//    ###### Wrong code

    public static void main(String[] args) {

        int arr1[]={10,10};
        int arr2[]={10};

        for(int i=0;i< arr1.length;i++){
            int count=0;
            for(int j=0;j< arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    count++;
                    if(count==2){
                        continue;
                    }
                    System.out.print(arr1[i]+" ");
                }
            }
        }
    }
}
