package com.Searching_And_Sorting;

public class Sum_of_Arrays_1 {

    public static void  sum(int arr1[], int arr2[]){

        int arr3[]=new int[Math.max(arr1.length,arr2.length)+1];
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=arr3.length-1;
        int carry=0;
        while(i>=0 && j>=0){
            int sum= arr1[i]+arr2[j]+carry ;
            carry=sum/10;
            int last_digit=sum%10;
            arr3[k]=last_digit;
            k--;
            i--;
            j--;
        }

//        if i is greater than length
        while(i>=0){
            int sum= arr1[i]+carry ;
            carry=sum/10;
            int last_digit=sum%10;
            arr3[k]=last_digit;
            k--;
            i--;

        }
        //   if j is greater than length

        while(i>=0){
            int sum= arr2[j]+carry ;
            carry=sum/10;
            int last_digit=sum%10;
            arr3[k]=last_digit;
            k--;
            j--;

        }
        arr3[0]=carry;


        for(int l:arr3){
            System.out.print(l+" ");
        }

    }


    public static void main(String[] args) {
        int arr1[]={4,1,2,1};
        int arr2[]={7,4,1,2};
        sum(arr1,arr2);

    }

}
