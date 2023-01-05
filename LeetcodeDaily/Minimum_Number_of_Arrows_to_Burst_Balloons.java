package com.LeetcodeDaily;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {

    public  static int  findMinArrowShots(int[][] points) {

        // not able to solve

        int arrowShots=0;
        int rows=points.length;
        int columns=points[0].length;
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                if(points[i][0] == -1 &&  points[j+1][1] == -1  && points[i][1] == -1  && points[j+1][0]==-1 ){
//                    return arrowShots;
//                }
//                if(points[i][0] < points[j+1][1] && points[i][1] > points[j+1][0]){
//                    //then arrow will hit these two balloons
//                    //and after hit make these disappear
//                    arrowShots++;
//                    points[i][0]=-1;
//                    points[j][1]=-1;
//                    points[i][1]=-1;
//                    points[j][0]=-1;
//
//                }
//            }
//        }

//        for(int i=0;i<rows;i++){
//                if(points[i][0] < points[j+1][1] && points[i][1] > points[j+1][0]){
//                    //then arrow will hit these two balloons
//                    //and after hit make these disappear
//                    arrowShots++;
//                    points[i][0]=-1;
//                    points[j][1]=-1;
//                    points[i][1]=-1;
//                    points[j][0]=-1;
//
//            }
//        }

        return arrowShots;
        // after loop is over , then those elements will be left with no overlap
        //then just simply return no of remaining elements

    }

    public static void main(String[] args) {
        int[][]  arr={{10,16},{2,8},{1,6},{7,12}};
//        int[][]  arr1={{1,1},{1,1},{1,6},{7,12}};

        System.out.println(findMinArrowShots(arr));

    }
}
