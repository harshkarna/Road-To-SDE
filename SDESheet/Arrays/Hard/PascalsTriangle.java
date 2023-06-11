/*
Given an integer numRows, return the first numRows of Pascal's triangle.

        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

        Example 1:

        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]


*/

package com.SDESheet.Arrays.Hard;

import java.util.ArrayList;

public class PascalsTriangle {

    /*
      0              1
      1             1 1
      2            1 2 1
      3           1 3 3 1
      4          1 4 6 4 1
      5        1 5 10 10 5 1

    In a interview based on pascal's triangle  3 types of questions can be asked
    1st->> Given a row and col , tell me the element at that place .
    2nd ->> Print the n th row of pascal's triangle.
    3rd -->>  Given N , print the entire pascal's triangle

    1st Problem - lets solve 1 pattern
    so if you are given r and c and you need to return the element , there is a formula for that
    ---> for a given r and c = r-1
                                  C
                                   c-1
    --> nCr= n!/r!*(n-r)!

    --> Given r is 5 and c = 3 , ans should be 6,
    --By formula  (do minus by 1 like n-1 and r-1 )--> 4C2 = 6

   --If you observe carefully  --> shortcut of nCr like 10C3= 10*9*8 /3*2*1


    2nd  Problem - lets solve 2nd pattern
    Nth row will always have n elements
    so brute force can be
    we can traverse on that row and call the ncr function on each n and r
    But here TO(n*r), can we optimise this ????


   3rd Problem :
   run 2 loops for row and col and inside col , call ncr function
   but TO(is  N3 nearly)

    *
    * */

    public static  int nCr(int n, int r) {
        int resultant=1;
        for(int i=0;i < resultant;i++){
            resultant=resultant*(n-i);
            resultant=resultant/(i+1);
        }
     return resultant;

    }

    public static ArrayList<Integer> generateRow(int row){
        int ans=1;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        for(int col =1; col < row ; col++){
            ans=ans * (row - col);
            ans=ans / col;
            answer.add(ans);
        }
        return answer;
    }

    public static  ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i =1;i <=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;

    }

    public static  ArrayList<ArrayList<Integer>> generate_v1(int numRows) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        for(int i =0; i < numRows;i++){
            ArrayList<Integer> row =new ArrayList<>();
            for(int j= 0 ; j <=i ; j++){
                if(j==0 || j== i){
                    row.add(1);
                }else{
                    row.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
                }
            }
            ans.add(row);
        }

        return ans;

    }


    public static  ArrayList<ArrayList<Integer>> generate_v2(int numRows) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        ArrayList<Integer> prev =new ArrayList<>();

        for(int i =0; i <  numRows;i++){
            ArrayList<Integer> row =new ArrayList<>();
            for(int j= 0 ; j <=i ; j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev=row;
            ans.add(row);
        }

        return ans;

    }



    public static void main(String[] args) {

        int numRows=5;
        ArrayList<ArrayList<Integer>> output = generate_v1(numRows);

        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
