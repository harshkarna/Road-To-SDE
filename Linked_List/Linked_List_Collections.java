package com.Linked_List;

import java.util.LinkedList;

public class Linked_List_Collections {

    public static void main(String[] args) {

        LinkedList <Integer> list=new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(1,100);
        list.addFirst(80);
        list.set(0,60);
//        list.remove();

//        System.out.println(list.get(1));
        System.out.println(list.size());

//        for (Integer integer : list) {
//            System.out.println(integer);
//        }

        for(int i: list){
            System.out.print(i+" ");
        }


    }
}
