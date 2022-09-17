//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
// return the area of the largest rectangle in the histogram.
//        Example 1:
//        Input: heights = [2,1,5,6,2,3]
//        Output: 10
//        Explanation: The above is a histogram where width of each bar is 1.
//        The largest rectangle is shown in the red area, which has an area = 10 units.
//        Example 2:
//
//
//        Input: heights = [2,4]
//        Output: 4

//https://leetcode.com/problems/largest-rectangle-in-histogram/

package com.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    //Not done hard question

    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        ArrayList <Integer> answer = new ArrayList<>(n);
        for(int i=n-1;i>=0;i--){
            int current=arr.get(i);
            while(stack.peek()!=-1 &&  arr.get(stack.peek())>=current){
                stack.pop();
            }
            //ans is stack of top
            answer.add(stack.peek());
            stack.push(i);
        }
        //To reverse the arraylist
        Collections.reverse(answer);
        return answer;
    }


    public static ArrayList<Integer> prevSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        ArrayList <Integer> answer = new ArrayList<>(n);
        for(int i=0;i>=n;i--){
            int current=arr.get(i);
            while(stack.peek()!=-1 &&  arr.get(stack.peek())>=current){
                stack.pop();
            }
            //ans is stack of top
            answer.add(stack.peek());
            stack.push(i);
        }
        //To reverse the arraylist
        Collections.reverse(answer);
        return answer;
    }

    public static int  largestRectangle( ArrayList <Integer> heights){
        int n=heights.size();
        ArrayList <Integer> next=new ArrayList<>(n);
        next=nextSmallerElement(heights,n);

        ArrayList <Integer> prev=new ArrayList<>(n);
        prev=prevSmallerElement(heights,n);

        int area=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int l= heights.get(i);
            if(next.get(i) ==-1){
                next.set(i,n);
            }
            int b =next.get(i)-prev.get(i)-1;
            int newArea=l*b;
            area=Math.max(area,newArea);
        }
        return area;
    }


    public static void main(String[] args) {
        ArrayList <Integer> arr= new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        System.out.println(largestRectangle(arr));
    }
}
