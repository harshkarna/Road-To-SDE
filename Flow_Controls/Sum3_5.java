package com.Flow_Controls;

public class Sum3_5 {

    public static void main(String[] args){
        int count =0;
        int sum =0;
        for (int i =1; i<=1000; i++){
            if (i%3==0 && i%5==0){
                System.out.println("Number divided by 3 and 5 = "+ i);
                count+=1;
                sum+=i;
                if (count == 5){
                    break;
                }
            }
        }
        System.out.println("The sum of all numbers is = " + sum);


    }
}
