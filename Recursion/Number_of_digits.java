//Number of Digits
//
//        Given the code to find out and return the number of digits present in a number recursively.
//        But it contains few bugs, that you need to rectify such that all the test cases should pass.
//        Input Format :
//        Integer n
//        Output Format :
//        Count of digits
//        Constraints :
//        1 <= n <= 10^6
//        Sample Input 1 :
//        156
//        Sample Output 1 :
//        3
//        Sample Input 2 :
//        7
//        Sample Output 2 :
//        1

package com.Recursion;

public class Number_of_digits {

    public static int no_of_digits(int n){
        if(n==0){ //base case can be 1 also
            return 0;
        }

        int smallcase=no_of_digits(n/10); ///small case
        return smallcase+1;

    }

    public static void main(String[] args) {
        int n =123456;
        int anw =no_of_digits(n);
        System.out.println(anw);

    }
}
