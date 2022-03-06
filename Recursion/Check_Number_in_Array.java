//Check Number in Array
//
//        Given an array of length N and an integer x, you need to find if x is present in the
//        array or not. Return true or false.
//        Do this recursively.
//        Input Format :
//        Line 1 : An Integer N i.e. size of array
//        Line 2 : N integers which are elements of the array, separated by spaces
//        Line 3 : Integer x
//        Output Format :
//        'true' or 'false'
//        Constraints :
//        1 <= N <= 10^3
//        Sample Input 1 :
//        3
//        9 8 10
//        8
//        Sample Output 1 :
//        true
//        Sample Input 2 :
//        3
//        9 8 10
//        2
//        Sample Output 2 :
//        false

package com.Recursion;

public class Check_Number_in_Array {

    public static boolean check_number(int arr[],int x){

        if(arr.length==1){
            if(arr[arr.length-1]==x){
                return true;
            }
            else return false;
        }

        if(arr[0]==x){
            return true;
        }

        int smallcase_arr[]=new int[arr.length-1];
        for(int i=1;i< arr.length;i++){
            smallcase_arr[i-1]=arr[i];
        }

        boolean smallcase=check_number(smallcase_arr,x);
         return smallcase;
    }


    public static void main(String[] args) {

        int arr[]={1,2,3,4};
        int x=5;

        System.out.println(check_number(arr,x));


    }
}
