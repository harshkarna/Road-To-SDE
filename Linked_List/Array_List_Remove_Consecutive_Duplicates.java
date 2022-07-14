package com.Linked_List;

import java.util.ArrayList;

public class Array_List_Remove_Consecutive_Duplicates {


    public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[]){
        ArrayList <Integer> al= new ArrayList<>();
        int a=0;

        for(int i=0;i<arr.length;i++){
            if(a!=arr[i]){
                al.add(arr[i]);
                a=arr[i];
            }
        }

        System.out.println(al);
        return null;

    }

    public static void main(String[] args) {

        int arr[] ={10,10,20,20,20,30,40,10};
        removeConsecutiveDuplicates(arr);


    }
}
