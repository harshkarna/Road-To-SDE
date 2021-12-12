package com.Flow_Controls;

public class DigitSum {

    public static int sumDigits(int number){
        int sum=0;
        if (number< 10){
            return -1;
        }
        while (number > 0){
          int k= number%10;
          sum= sum+k;
          number = number/10;
        }
           return sum;
    }

    public static void main(String[] args) {

        System.out.println(sumDigits(125));


    }
}
