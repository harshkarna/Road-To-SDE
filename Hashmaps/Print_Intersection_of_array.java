package com.Hashmaps;

import java.util.HashMap;

public class Print_Intersection_of_array {

    private static void printIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        //create a freq array for one array
        for(int i:arr1){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        //now we will iterate over the second array and check if arr2[i] is present in
        //map's key , then will gets its value and if its > 0 means intersection
        for(int i:arr2){
            if(map.containsKey(i)){
                int freq=map.get(i);
                if(freq > 0){
                    //means intersection
                    System.out.print(i+" ");
                    //decrease the freq by 1
                    map.put(i,freq-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr1[]={1,4,5,2,2,3,6,5,3,2};
        int arr2[]={2,3,2,6,6,5,1};

        printIntersection(arr1,arr2);

    }

}
