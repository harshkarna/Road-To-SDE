package com.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Next_smaller_element {

    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        ArrayList <Integer> answer = new ArrayList<>(n);
        for(int i=n-1;i>=0;i--){
            int current=arr.get(i);
            while(stack.peek()>=current){
                stack.pop();
            }
            //ans is stack of top
            answer.add(stack.peek());
            stack.push(current);
        }
        //To reverse the arraylist
        Collections.reverse(answer);
        return answer;
    }

    public static void main(String[] args) {
        ArrayList <Integer> arr= new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);
        int size = arr.size();

        arr=nextSmallerElement(arr,size);

        for(int i : arr){
            System.out.print(i +" ");
        }

    }
}
