//A celebrity is a person who is known to all but does not know anyone at a party.
// If you go to a party of N people, find if there is a celebrity in the party or not.
//        A square NxN matrix M[][] is used to represent people at the party such that
//        if an element of row i and column j  is set to 1 it means ith person knows jth person.
//        Here M[i][i] will always be 0.
//        Note: Follow 0 based indexing.
//        Follow Up: Can you optimize it to O(N)
//
//
//        Example 1:
//
//        Input:
//        N = 3
//        M[][] = {{0 1 0},
//        {0 0 0},
//        {0 1 0}}
//        Output: 1
//        Explanation: 0th and 2nd person both
//        know 1. Therefore, 1 is the celebrity.
//
//        Example 2:
//
//        Input:
//        N = 2
//        M[][] = {{0 1},
//        {1 0}}
//        Output: -1
//        Explanation: The two people at the party both
//        know each other. None of them is a celebrity.
//
//        Your Task:
//        You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.
//
//
//        Expected Time Complexity: O(N^2)
//        Expected Auxiliary Space: O(1)
//

package com.Stack;

import java.util.Stack;

public class The_Celebrity_Problem {

    private static boolean knows(int M[][],int a , int b, int n){
        if(M[a][b]==1){
            return true;
        }
        else{
            return false;
        }
    }
    //Function to find if there is a celebrity in the party or not.
    public static int  celebrity(int M[][], int n)
    {
        //Step 1: Push all elements/persons  in stack
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }

        //Step :2 get the 2 elements from stack and compare them
        while(stack.size() >1){
            int a=stack.peek();
            stack.pop();

            int b =stack.peek();
            stack.pop();

            //Checking if a knows B , IF YES then a cannot be celebrity and push b in stack or vice versa
            //and we need to always push other one who doesnt know anybody to stack
            if(knows(M,a,b,n)){
                stack.push(b);
            }
            else{
                stack.push(a);
            }
        }
        //after this while we willl be left with 1 value in stack
        //thats our potential candidate for celebrity
        int potential_candidate=stack.peek();

        //step3: single element in stack is potential celeb
        //so verify it

        //check for row
        boolean rowCheck=false;
        int zeroCount=0;
        for(int i=0;i<n;i++){
            if(M[potential_candidate][i]==0){
                zeroCount++;
            }
        }

        if(zeroCount ==n){
            rowCheck=true;
        }

        //check for col
        boolean colCheck=false;
        int oneCount=0;
        for(int i=0;i<n;i++){
            if(M[i][potential_candidate]==1){
                oneCount++;
            }
        }

        //here n-1 because of diagonal will be always 0
        if(oneCount ==n-1){
            colCheck=true;
        }

        if( rowCheck==true && colCheck ==true){
            return potential_candidate;
        }
        else{
            return -1;
        }

    }

    public static void main(String[] args) {

        int n =3;
        int[][] M={{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(celebrity(M,n));
    }
}
