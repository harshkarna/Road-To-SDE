package com.SDESheet.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class Intersection_two_sorted_arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        //creating 1 set  and 1 arraylist
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        //Removing duplicates from firts array
        for(int i :nums1){
            set.add(i);
        }

        //now iterate in second array and , add in list whatever we found similar in set already ,
        //and once found keep removing from set as duplicates might come again in second array
        for(int i :nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }

        //copy whatever in list in array and return
        int[] output=new int[list.size()];
        for(int i=0; i < list.size();i++ ){
            output[i]=list.get(i);
        }

        return output;

    }

}
