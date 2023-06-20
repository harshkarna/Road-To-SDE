/*
You are given 2 numbers (n , m); the task is to find n√m (nth root of m).


        Example 1:

        Input: n = 2, m = 9
        Output: 3
        Explanation: 32 = 9
        Example 2:

        Input: n = 3, m = 9
        Output: -1
        Explanation: 3rd root of 9 is not
        integer.

*/

package com.SDESheet.BinarySearch.BS_Answers;
public class FindNthRoot {

   /*
   This question is same like as we did for Nth root
   * So basically we need to find the range and find the pattern
   * in which there is a set of range of possibilities
   *
   *  */



    private static int multiply(int mid ,int n, int m) {
        long ans = 1;
        for(int i = 1;i<=n;i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    public  static int  NthRoot(int n, int m){
        int low = 1;
        int high = m;

        while(low <= high) {
            int mid = (low + high) / 2;
            //if your mid is ans , return it
            if(multiply(mid, n,m) == 1 ) return mid ;
            //is mid is less than m , then it means there is a chance of
            //more bigger  number that can be our answer , so move to right
            if(multiply(mid, n,m) ==0) {
                low = mid+1;
            }
            //if greater , then no need to go further , lets eliminate right and move to left
            else {
                high = mid-1;
            }
        }
         return -1 ;
    }


    public static void main(String[] args) {


    }
}
