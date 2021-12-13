package com.Searching_And_Sorting;


public class Merge_2_SortedArrays {

    public static int[] merge2sortedarrays(int arr1[],int arr2[]){
        int i=0;
        int j=0;
        int size= arr1.length+ arr2.length;
        int arr3[] = new int[size];
        int k=0;

        while(i< arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k]=arr2[j];
                j++;
                k++;
            }
        }

        while(i<arr1.length){
            arr3[k]=arr1[i];
            i++;
            k++;
        }

        while(j<arr2.length){
            arr3[k]= arr2[j];
            j++;
            k++;
        }
        return arr3;
    }

    public static void main(String[] args) {
        int arr1[]={1,4,6,9,10};
        int arr2[]={3,5,7,8};
        int arr3[]=merge2sortedarrays(arr1, arr2);

        //display of array
        for(int i=0;i <arr3.length; i++){
            System.out.print(arr3[i]+" ");
        }

    }
}
