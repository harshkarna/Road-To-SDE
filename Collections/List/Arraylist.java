package com.Collections.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arraylist {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList(); // Creating a new
        // List which will be added to original list.
        list.add(1);
        list.add(2);      //.add will add element at last

        //to add at particular index
        list.add(0,0);


        System.out.println(list);

        List<Integer> newlist = new ArrayList(); // Creating a new
        // List which will be added to original list.
        newlist.add(4);
        newlist.add(5);

        list.addAll(newlist);
        System.out.println(list);

       //to fetch elements by giving index
        System.out.println(list.get(1));

        //to remove element
        list.remove(1);
        System.out.println(list);

        List<Integer> secondlist = new ArrayList<>();
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);

        System.out.println(secondlist);

        //3 ways to traverse arraylist

        for (int i = 0; i < secondlist.size(); i++) {
            System.out.println("the element is " + list.get(i));
        }


        //recommended
        for (Integer element: secondlist) {
            System.out.println("foreach element is " + element);
        }


        Iterator<Integer> it = secondlist.iterator();

        while (it.hasNext()) {
            System.out.println("iterator " + it.next());
        }

        //update particluar index value
        list.set(2, 1000);

        System.out.println(list);

        //returns boolean true or false
        System.out.println(list.contains(500));

        list.remove(1);  // This will remove the element at index 1 i.e 20.
        System.out.println(list);

        list.remove(Integer.valueOf(30)); // This will remove 30 from the list
        System.out.println(list);

        list.clear(); //This will remove all the elements from the list.
        System.out.println(list);



    }


}
