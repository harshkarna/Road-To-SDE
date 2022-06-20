//Return subset of an array
//
//        Given an integer array (of length n), find and return all the subsets of input array.
//        Subsets are of length varying from 0 to n, that contain elements of the array.
//        But the order of elements should remain same as in the input array.
//        Note : The order of subsets are not important.
//        Input format :
//
//        Line 1 : Size of array
//
//        Line 2 : Array elements (separated by space)
//
//        Sample Input:
//        3
//        15 20 12
//        Sample Output:
//        [] (this just represents an empty array, don't worry about the square brackets)
//        12
//        20
//        20 12
//        15
//        15 12
//        15 20
//        15 20 12

package com.Recusrion_Part2;

import java.util.Scanner;

public class Return_Subset_of_Array {

    public static int[][] return_subset_array(int[] arr, int startIndex){
        //base case
        if(startIndex==arr.length){
            int[][] output=new int[1][0];
            return output;
         }

        int[][] smaller_output = return_subset_array(arr,startIndex+1);
        int[][] output =new int[smaller_output.length*2][];

        int k=0;
        for(int i=0;i< smaller_output.length;i++){
            output[k]=new int[smaller_output[i].length];
            for(int j=0;j<smaller_output[i].length;j++){
                output[k][j]=smaller_output[i][j];
            }
            k++;
        }

        for(int i=0;i<smaller_output.length;i++){
            output[k]=new int[smaller_output[i].length+1];
            output[k][0]=arr[startIndex];
            for(int j=1;j<smaller_output[i].length;j++){
                output[k][j]=smaller_output[i][j-1];
            }
            k++;
        }
        return output;
    }

    public static int[][] return_subset_array(int arr[]){
        return return_subset_array(arr,0);
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int size =sc.nextInt();
        int arr[]=new int[size];

        for(int i=0;i< size;i++){
            arr[i]=sc.nextInt();
        }

        int[][] arr_final=return_subset_array(arr);

        int rows=arr_final.length;
        int cols=arr_final[0].length;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr_final[i][j]+" ");
            }
            System.out.println();
        }

    }
}
