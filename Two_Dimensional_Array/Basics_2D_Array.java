package com.Two_Dimensional_Array;

public class Basics_2D_Array {

    public static void main(String[] args) {

        int[][] arr2d=new int[3][4];
        System.out.println(arr2d[1][2]);
        arr2d[2][1]=12;
        System.out.println(arr2d[2][1]);

        int[][] arr2d1={{1,2,3,4},{2,3,4,5},{5,6,7,8}};
        System.out.println(arr2d1.length);
        System.out.println(arr2d1[0].length);


    }
}
