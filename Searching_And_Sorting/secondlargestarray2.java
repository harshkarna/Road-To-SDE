package com.Searching_And_Sorting;

public class secondlargestarray2 {

    public static int secondlargestinarray(int arr[]){
        int temp;
        int n=arr.length;
        int secondlast=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j+1]<arr[j]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
       for(int j=n-1;j>=0;j--){
            if(arr[j]!=arr[j-1]){
                secondlast=arr[j-1];
                break;
            }
        }
        return secondlast;
    }

    public static void main(String[] args) {

//        int arr[]={13,9,7,3,76,86};
        int arr[]={90,6,90,90,8};
        int arr1=secondlargestinarray(arr);
        System.out.println(arr1);


    }
}
