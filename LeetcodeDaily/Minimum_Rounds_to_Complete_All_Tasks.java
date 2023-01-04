package com.LeetcodeDaily;

import java.util.HashMap;

public class Minimum_Rounds_to_Complete_All_Tasks {

    //Better approach

    public static int minimumRounds(int[] tasks) {
        int minimumRounds=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        //creating the frequency array
        for(int key : tasks){
            map.put(key,map.getOrDefault(key,0)+1);
        }

        //traversing over the map Values
        for(int count : map.values()){
            // If the frequency is 1, it's not possible to complete tasks.
            if(count == 1){
                return -1;
            }

            if(count % 3 == 0){
                // Group all the task in triplets.
                minimumRounds = minimumRounds + count/3;
            }
            else{
                //Now only 2 options are left
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                minimumRounds = minimumRounds + count/3 + 1 ;

            }

        }
        return minimumRounds;

    //Below tried brute force 1st attempt

   /* public static boolean checkPrime(int num){
        for (int i = 2; i < num/2; i++) {
            if(num % i == 0 ) {
                return false;
            }
        }
        return true;
    }

    public  static int  minimumRounds(int[] tasks) {
        int minimumRounds=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        //creating the frequency array
        for(int i=0;i<tasks.length;i++){
            if(map.containsKey(tasks[i])){
               map.put(tasks[i],map.get(tasks[i])+1);
            }
            else{
                map.put(tasks[i],1);
            }
        }

        //traversing over the map
        for(Map.Entry<Integer,Integer> mapElement:map.entrySet()){
            int key =mapElement.getKey();
            int value =mapElement.getValue();
            if(value == 1){
                return -1;
            }

            if(value ==2 || value ==4){
                int d= value/2;
                minimumRounds=minimumRounds+d;
                continue;
            }

            if(checkPrime(value)){
                if((value % 3 ==2) || (value % 3 ==1)){
                    int d3 =value/3;
                    minimumRounds=minimumRounds+d3+1;
                    continue;
                }
            }
            if( value % 3==0){
                int d1= value/3;
                minimumRounds=minimumRounds+d1;
            }
            else{
                int d4=value/3;
                int r4=value % 3;
                if(r4==1 || r4 ==2){
                    minimumRounds=minimumRounds+d4+1;
                }
           }
        }
        return minimumRounds;*/

    }


    public static void main(String[] args) {
         int tasks[]  = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
//        int tasks[]  = {66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61};
//        int tasks[]  = {2,2,3,3,2,4,4,4,4,4};
//        int tasks[]  = {2,2,2,3,3,3,3,4,4,4,4,4};
//         getfreqArray(tasks);

        System.out.println(minimumRounds(tasks));

    }


}
