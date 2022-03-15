//Merge Sort Code
//
//        Sort an array A using Merge Sort.
//        Change in the input array itself. So no need to return or print anything.
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
//        2 1 5 2 3
//        Sample Output 2 :
//        1 2 2 3 5


package com.Recursion;

public class Merge_Sort_Code {

    public static void merge(int[] arr,int startIndex, int endIndex){
        int size=endIndex-startIndex+1;
        int mid=(startIndex+endIndex)/2;
        int[] output = new int [size];
        int i =startIndex;
        int j=mid+1;
        int k=0;

        // we have 2 parts of sorted array and we are merging 2 sorted parts in 1 temporary array in sorted manner
        while(i<=mid && j<=endIndex){
            if(arr[i]<arr[j]){
                output[k]=arr[i];
                i++;
                k++;
            }
            else{
                output[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            output[k]=arr[i];
            i++;
            k++;
        }
        while(j<=endIndex){
            output[k]=arr[j];
            j++;
            k++;
        }
        int m=0;

        //for copying back sorted temporary array to main array
        for(int n=startIndex;n<=endIndex;n++){
            arr[n]=output[m];
            m++;
        }
    }


    public static void  merge_sort(int[] arr,int startIndex,int endIndex){
        //base case when only 1 element is there
      if(startIndex>=endIndex){
          return ;
      }

      int mid =(startIndex+endIndex)/2;
      merge_sort(arr,startIndex,mid);
      merge_sort(arr,mid+1,endIndex);
      merge(arr,startIndex,endIndex);

    }

    public static void main(String[] args) {
       int arr[]={2,8,6,5,4,3};
       merge_sort(arr,0, arr.length-1);


       for(int i :arr ){
           System.out.print(i +" ");
       }

    }
}
