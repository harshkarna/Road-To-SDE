//Pair Sum to 0
//
//        Given a random integer array A of size N.
//        Find and print the count of pair of elements in the array which sum up to 0.
//        Note: Array A can contain duplicate elements as well.
//        Input format:
//        The first line of input contains an integer, that denotes the value of the size of the array.
//        Let us denote it with the symbol N.
//        The following line contains N space separated integers, that denote the value of the elements
//        of the array.
//        Output format :
//        The first and only line of output contains the count of pair of elements in the array which sum up to 0.
//        Constraints :
//        0 <= N <= 10^4
//        Time Limit: 1 sec
//        Sample Input 1:
//        5
//        2 1 -2 2 3
//        Sample Output 1:
//        2

package com.Hashmaps;

import java.util.HashMap;

public class PairSumToZero {

    private static int getcountpairsumtozero(int[] arr) {
        int finalCount=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        // create the  freq table
        for(int i :arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i : arr){
            int times;
            if(map.containsKey(-i) && map.get(i)!=0){
                //checking when key is 0
                //just get its freq number and apply formula and then make its val 0.
                if(i==0){
                    int occurrences = map.get(i);
                    //same elements pair formula
                    times = (occurrences * (occurrences - 1)) / 2;
                    finalCount = finalCount+times;
                    map.put(i, 0);
                }
                //handling non zero key cases
                times=map.get(i) * map.get(-i);
                finalCount=finalCount+times;
                map.put(i,0);
                map.put(-i,0);
            }
        }
        return finalCount;
    }

    public static void main(String[] args) {
//        int arr[]={2,1,-2,2,3};
//          int arr1[]={-2,2,6,-2,2,-6,3};
        int arr1[]={0,-2,2,0,6,-2,2,-6,0,3,0};
//        int arr1[]={0,0,0,0};

        System.out.println(getcountpairsumtozero(arr1));
    }

}
