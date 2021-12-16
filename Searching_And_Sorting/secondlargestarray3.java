package com.Searching_And_Sorting;

public class secondlargestarray3 {

    public static int secondlargestinarray(int arr[]){
        int l=arr[0];

        int sl =Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>l){
                sl=l;
                l=arr[i];
            }
            else if(arr[i]<l && arr[i]>sl){
                    sl=arr[i];
            }
//            else if(arr[i]==l || (arr[i]<l && arr[i]<sl) ){
//                continue;
//            }
        }
        return sl;
    }

    public static void main(String[] args) {

//        int arr[]={13,9,7,3,76,86};
        int arr[]={90,6,90,90,8};
//        int arr[]={3,5,1,9,7,11};
        int arr1=secondlargestinarray(arr);
        System.out.println(arr1);


    }
}
