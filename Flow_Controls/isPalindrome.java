package com.Flow_Controls;

public class isPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12321));

    }
        public static boolean isPalindrome(int number){

            number = Math.abs(number);

            int lastDigit=0;
            int reverse =0;
            int number_copy =number;

            while (number_copy>0){
                lastDigit= number_copy % 10;
                reverse =reverse *10 +lastDigit;
                number_copy = number_copy/10;
            }
            if (number == reverse){
                return true;
            }
            else return false;
        }

}
