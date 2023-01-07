package com.LeetcodeDaily;

import java.util.Arrays;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {

    public  static int  findMinArrowShots(int[][] points) {
        //if array is empty
        if (points.length==0){
            return 0;
        }
        //sort the array
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int arrowShots=1;

        int end =points[0][1];
        for(int i=1;i <points.length;i++){
            if(points[i][0] > end){
                arrowShots++;
                end=points[i][1];
            }
        }

        return arrowShots;

    }

    public static void main(String[] args) {
        int[][]  arr={{10,16},{2,8},{1,6},{7,12}};
//        int[][]  arr1={{1,1},{1,1},{1,6},{7,12}};

        System.out.println(findMinArrowShots(arr));

    }
}
