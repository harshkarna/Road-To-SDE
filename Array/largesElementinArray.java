package com.Array;

public class largesElementinArray {

    public static void main(String[] args) {

        int max =Integer.MIN_VALUE;
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//
//        //input in Array
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
        int arr[]={1,2,3,4,5,6,7,17,9};
        for(int i=0;i< arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Max is="+ max);






    }
}
