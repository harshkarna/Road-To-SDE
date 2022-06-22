package com.OOPS_part1;


public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray d=new DynamicArray();

       for (int i=0;i< 100;i++){
           d.add(100+i);
       }

       d.size();
       d.get(2);
       d.set(2,121);
       d.get(2);



    }

}
