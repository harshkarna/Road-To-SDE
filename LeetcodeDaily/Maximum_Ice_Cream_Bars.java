package com.LeetcodeDaily;

import java.util.Arrays;

public class Maximum_Ice_Cream_Bars {

    public static int maxIceCream(int[] costs, int coins) {
        //Sort the array
        Arrays.sort(costs);
        int count=0;

        for(int i=0;i<costs.length;i++){
            if(costs[i]<coins){
                count++;
                coins=coins-costs[i];
            }
        }

      return count;

    }

    public static void main(String[] args) {

        int[] costs = {7,3,3,6,6,6,10,5,9,2};
        System.out.println(maxIceCream(costs,56));

    }
}
