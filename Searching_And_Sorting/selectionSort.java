package com.Searching_And_Sorting;

public class selectionSort {
    public static void selectionsort(int arr[]){

        for (int i=0;i<arr.length;i++){
            int min=arr[i];
            int minIndex=i;

            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;

            }
        }

    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//
//        //input in Array
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }

        int arr[]={2,6,9,1,5};

        selectionsort(arr);
        for(int i=0;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }


    }
}
