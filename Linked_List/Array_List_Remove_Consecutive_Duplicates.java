package com.Linked_List;

import java.util.ArrayList;

public class Array_List_Remove_Consecutive_Duplicates {


    public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[]){
        ArrayList <Integer> al= new ArrayList<>();
        al.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                al.add(arr[i]);
            }
        }

        System.out.println(al);
        return al;
    }

    public static void main(String[] args) {

        int arr[] ={10,10,20,20,20,30,40,10};
        removeConsecutiveDuplicates(arr);


    }
}
