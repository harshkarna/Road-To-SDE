package com.Hashmaps;

import java.util.HashMap;
import java.util.Set;

public class InbuiltMapUse {

    public static void main(String[] args) {

        HashMap<String,Integer>  map=new HashMap<>();
        //insert
        map.put("abc",1);
        map.put("def",2);

        //to check the key presence
        if(map.containsKey("abc")){
            System.out.println("Map contains abc");
        }

        //to get the value
        int v =map.get("abc");
        System.out.println("Key is " +  v);

        if(map.containsKey("abc1")){
            int v1 =map.get("abc");
            System.out.println("Key is " +  v1);
        }

        // to remove
        map.remove("abc");

        ///to get size
        System.out.println(map.size());


        //to iterate over the keys
        Set<String> keys =map.keySet();
        for(String s:keys){
            System.out.println(s);
        }



    }
}
