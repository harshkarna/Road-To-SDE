package com.LeetcodeDaily;

import java.util.HashMap;

public class Word_Pattern {

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<>();

        String[] s_arr=s.split(" ");
        //case to check length of pattern and string array
        if(pattern.length()!=s_arr.length){
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            //case to chekc if a new key is coming with  same previously inserted value for some other key in map
            if(!map.containsKey(pattern.charAt(i)) && map.containsValue(s_arr[i]))  {
                return false;
            }
            //case if key is present, first check if that value in s is same as of in map or not
            if(map.containsKey(pattern.charAt(i))){
                String tocheck=map.get(pattern.charAt(i));
                if(!tocheck.equals(s_arr[i])){
                    return false;
                }
            }
            else{
                map.put(pattern.charAt(i),s_arr[i]);
            }
        }
        return true;

    }

    public static void main(String[] args) {
       String s="dog cat cat dog";
       System.out.println(wordPattern("aaa","aa aa aa aa"));

    }

}
