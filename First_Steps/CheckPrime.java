package com.First_Steps;

public class CheckPrime {

    public static boolean checkprime(int n ){

        for (int i = 2; i < n; i++) {
            if(n % i == 0 ) {
                return false;
               }
            }
        return true;
    }

    public static void main(String[] args) {

       if(checkprime(18)){
           System.out.println("Yes its Prime");
       }
       else {
           System.out.println("No its not Prime");
       }
    }
}
