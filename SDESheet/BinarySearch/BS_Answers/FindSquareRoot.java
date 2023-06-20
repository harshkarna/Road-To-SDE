/*Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).



        Example 1:

        Input:
        x = 5
        Output: 2
        Explanation: Since, 5 is not a perfect
        square, floor of square_root of 5 is 2

        .*/

package com.SDESheet.BinarySearch.BS_Answers;
public class FindSquareRoot {

    long floorSqrt(long x){
        long low=1;
        long high=x;
        long ans=x;
        while(low <=high){
            long mid= (low+high)/2;
            long val = mid*mid;
            if(val <= x){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }

        // Your code here


    public static void main(String[] args) {


    }
}
