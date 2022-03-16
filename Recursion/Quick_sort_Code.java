//Quick Sort Code
//
//        Sort an array A using Quick Sort.
//        Change in the input array itself. So no need to return or print anything.
//
//
//        Input format :
//        Line 1 : Integer n i.e. Array size
//        Line 2 : Array elements (separated by space)
//        Output format :
//        Array elements in increasing order (separated by space)
//        Constraints :
//        1 <= n <= 10^3
//        Sample Input 1 :
//        6
//        2 6 8 5 4 3
//        Sample Output 1 :
//        2 3 4 5 6 8
//        Sample Input 2 :
//        5
//        1 5 2 7 3
//        Sample Output 2 :
//        1 2 3 5 7

package com.Recursion;

public class Quick_sort_Code {


    public static int partition(int arr[],int startIndex,int endIndex){
        // pivot is the first element of that range to check
        int pivot =arr[startIndex];
        //taking counts of how many numbers are smaller than pivit so that we can place the pivot
        //in its proper position and replace tha element present their to pivot Index
        int countSmaller=0;
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]<=pivot){
                countSmaller++;
            }
        }
        int pivotIndex=countSmaller+startIndex;
        //swapping
        arr[startIndex]=arr[pivotIndex];
        arr[pivotIndex]=pivot;

        int i=startIndex;
        int j=endIndex;
        //Now we will ensure that left side all should be smaller than pivot and
        //all right should be greater than pivot so we will take 2 pointers for it
        while(i<pivotIndex && j > pivotIndex ){
            if(arr[i]<=pivot){
                i++;
            }
            else if(arr[j]>pivot){
                j--;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    public static void quick_sort(int arr[], int startIndex,int endIndex){
        //Creating base case
        if(startIndex>=endIndex){
            return;
        }

        //creating partion for which x al left side will be smaller and all right side will be greater
        int p =partition(arr,startIndex, endIndex);
        quick_sort(arr,startIndex,p-1);
        quick_sort(arr,p+1,endIndex);
    }


    public static void main(String[] args) {
        int arr[]={5,8,7,3,1,9};
        quick_sort(arr,0,arr.length-1);

        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}
