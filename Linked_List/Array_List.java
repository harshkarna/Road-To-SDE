package com.Linked_List;

import java.util.ArrayList;

public class Array_List {

    public static void main(String[] args) {
        ArrayList <Integer> arr= new ArrayList<>();
//        ArrayList <Integer> arr= new ArrayList<>(20); for initial capacity and
        //Initial capacity and size are different

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(3,40);
//        arr.remove(2);
        arr.set(0,100);

        System.out.println("Size of array " + arr.size());
        System.out.println(arr);
//        System.out.println(arr.get(2));

        //Travering array list
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
//        or
        System.out.println();
        //Enhanced for Loop -for each loop
        for(int i : arr){
            System.out.print(i +" ");
        }

    }


}
