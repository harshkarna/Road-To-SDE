package com.Basic;

import java.util.Scanner;

public class CountToffee {

    private static int  countToffee(int rs) {
        int originalAmount=rs*3;
        int getToffee=rs*3;
        int count=0;

        //now for every 3 wrapper , means 1 toffee back you will get 1 toffe
        while(getToffee > 0){
            getToffee=getToffee/3;
            count=count+getToffee;
        }
        System.out.println("Here is your all toffees count ");
        return count+ originalAmount ;

    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Rupees you are having ");
        int rupess=sc.nextInt();
        System.out.println(countToffee(rupess));
    }


}
