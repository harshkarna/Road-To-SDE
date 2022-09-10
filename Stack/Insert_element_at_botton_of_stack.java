package com.Stack;

import java.util.Stack;

public class Insert_element_at_botton_of_stack {

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

    public static void main(String[] args) {

        int arr[]={1,2,3,4};
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        insert_at_bottom(stack,5);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

