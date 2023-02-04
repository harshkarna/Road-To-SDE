//Extract Unique characters
//
//        Given a string S, you need to remove all the duplicates. T
//        hat means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
//        Input format:
//        The first and only line of input contains a string, that denotes the value of S.
//        Output format :
//        The first and only line of output contains the updated string, as described in the task.
//        Constraints :
//        0 <= Length of S <= 10^8
//        Time Limit: 1 sec
//        Sample Input 1 :
//        ababacd
//        Sample Output 1 :
//        abcd
//        Sample Input 2 :
//        abcde
//        Sample Output 2 :
//        abcde

package com.Hashmaps;

import java.util.HashMap;

public class extract_unique_characters {

    private static String getuniquecharacters(String str) {

        HashMap<Character,Boolean> map=new HashMap<>();
        String ans="";
        //What we will do ki for every new char we found will put that in map and ans string
        for(int i=0;i <str.length();i++){
            char s=str.charAt(i);
            if(!map.containsKey(s)){
                map.put(s,true);
                ans=ans + s;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str="abcdeeb";
        System.out.println(getuniquecharacters(str));

    }


}
