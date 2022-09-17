package com.Stack;

import java.util.Stack;

public class Sort_Stack_using_Recursion {
     public static  void insert_in_sorted_way(Stack<Integer> stack, int tocheck){
         //base case
         if(stack.isEmpty() || tocheck > stack.peek()){
             stack.push(tocheck);
             return;
         }
         int top =stack.peek();
         stack.pop();
         insert_in_sorted_way(stack,tocheck);
         stack.push(top);
     }


    public static void sort_stack(Stack<Integer> stack){
        //base case
        if(stack.isEmpty()){
            return;
        }

        int top=stack.peek();
        stack.pop();
        sort_stack(stack);
        insert_in_sorted_way(stack,top);

    }

    public static void main(String[] args) {
        int arr[]={1,5,3,4,2};
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        sort_stack(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
