package com.Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {



    /*Approach 1 : Using set O(n)
    Approach 2 : Hashmap
    Approach 3 : Sorting nlogn
    * */


    private static ArrayList<Integer> removeDuplicates(int[] arr) {
        //to store our answer
        ArrayList<Integer> output=new ArrayList<>();

        //Create a hashmap
        HashMap<Integer,Boolean> map=new HashMap<>();

        //loop to iterate over given arr
        for(int i=0;i<arr.length;i++){
            //if key alreday there , then move forward
            if(map.containsKey(arr[i])){
                continue;
            }
            //otherwise add in final output and also in map
            output.add(arr[i]);
            map.put(arr[i],true);
        }

        return output;
    }

    public static void main(String[] args) {

        int arr[] = {1,3,2,2,3,1,6,2,5};
        ArrayList<Integer> output=removeDuplicates(arr);
        System.out.println(output);

    }

}
