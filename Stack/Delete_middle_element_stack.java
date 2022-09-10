package com.Stack;

import java.util.Stack;

public class Delete_middle_element_stack {

    public static void delete_middle(Stack<Integer> input,int count, int size) {
        //base case
        //and middle element find formula
        //here size if the size of resulting stack
        if (count == size / 2) {
            input.pop();
            return;
        }
        //store the top element and then pop it
        int num=input.peek();
        input.pop();

        //Recursive call
        delete_middle(input, count+1,size);
        //while returning back , place the top most element in the stack
        input.push(num);

    }


    public static void main(String[] args) {

        int arr[]={1,2,3,4};
        Stack <Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        delete_middle(stack,0, 4);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
