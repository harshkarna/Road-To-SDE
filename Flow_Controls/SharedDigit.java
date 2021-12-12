package com.Flow_Controls;

public class SharedDigit {

    public static void main(String[] args) {
        hasSharedDigit(13,12);
    }

        public static boolean hasSharedDigit(int n1, int n2){

            if (n1 < 10 ||n1 > 99 || n2 < 10 || n2 > 99) {
                System.out.println("False");
                return false;
            }


            int to_check_n1 =0;
            int to_check_n2 =0;
            int n2_round =n2;

            while (n1>0){
                to_check_n1 = n1 % 10;
                n2=n2_round;
                while (n2 >0){
                    to_check_n2 = n2 % 10;
                    if(to_check_n2 == to_check_n1){
                        System.out.println("True");
                        return true;
                    }
                    n2 = n2 /10;
                }
                n1 = n1/10;
            }
            System.out.println("False");
            return false;

        }
    }


