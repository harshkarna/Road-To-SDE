package com.Stack;

import java.util.Stack;

public class Reverse_stack_using_Recusion {

    public static void insert_at_bottom(Stack <Integer> stack, int x){
        //base case
        if(stack.isEmpty()){
            stack.push(x);
            return ;
        }

        int top=stack.peek();
        stack.pop();

        insert_at_bottom(stack,x);
        stack.push(top);
    }

    public static void reverse_by_recusrion(Stack<Integer> stack){
        ///base case
        if(stack.isEmpty()){
            return;
        }
        //Solve it for 1 case rest recursion will handle
        int top=stack.peek();
        stack.pop();

        reverse_by_recusrion(stack);
        //after reversring we need to put top element stored at last at last
        insert_at_bottom(stack,top);

    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        reverse_by_recusrion(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }
}
