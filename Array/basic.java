

package com.Array;

import java.util.Scanner;

public class basic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];

        //input in Array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //display of array
        for(int i=0;i < size; i++){
            System.out.print(arr[i]+" ");
        }

    }

}