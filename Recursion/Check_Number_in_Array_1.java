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

public class Check_Number_in_Array_1 {

    public static boolean check_number(int arr[],int x,int startIndex){
        //taking base case as 1

        if(startIndex==arr.length-1){
            if(arr[arr.length-1]==x){
                return true;
            }
            else return false;
        }
        if(arr[startIndex]==x){
            return true;
        }

        boolean smallcase=check_number(arr, x, startIndex+1);
        return smallcase;
    }


    public static boolean check_number_1(int arr[],int x,int startIndex){

        //taking base case as 0

        if(arr[startIndex]==arr.length){
            return false;
        }

        if(arr[startIndex]==x){
            return true;
        }
        boolean smallcase=check_number(arr, x, startIndex+1);
        return smallcase;

    }

    public static void main(String[] args) {

        int arr[]={1,2,3,4};
        int x=1;

        System.out.println(check_number_1(arr,x,0));

    }
}
