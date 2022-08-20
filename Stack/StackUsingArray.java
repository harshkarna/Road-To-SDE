package com.Stack;

public class StackUsingArray {

    private int data[];
    private int topIndex; //Index of the topmost element of the stack

    public StackUsingArray(){
        data=new int[10];
        topIndex=-1;
    }

    public StackUsingArray(int size){
        data=new int[size];
        topIndex=-1;
    }

    //O(1)
    public int size(){

        return topIndex+1;
    }

    //O(1)
    public boolean isEmpty(){
//        if (topIndex==-1){
//            return true;
//        }else{
//            return false;
//        }
        return topIndex== -1;//shorter version
    }

//    //O(1)
//    public void push(int elem) throws StackFullException {
//        //if stack is fill
//        if(topIndex==data.length-1){
//            //Throw Exception
////            StackFullException e =new StackFullException();
////            throw e;
//            throw new StackFullException();
//        }
//
//        topIndex++;
//        data[topIndex]=elem; //or data[++topIndex]=elem
//    }

    public void push(int elem)  {
        //if stack is fill
        if(topIndex==data.length-1){
            //Throw Exception
//            StackFullException e =new StackFullException();
//            throw e;
            doubleCapacity();
        }

        topIndex++;
        data[topIndex]=elem; //or data[++topIndex]=elem
    }

    private void doubleCapacity() {
        int temp[]=data;
        data=new int[2*temp.length];
    }

    //O(1)
    public int top() throws StackEmptyException {
        if(topIndex==-1){
            //Throw stackEmpty expection
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    //O(1)
    public int pop() throws StackEmptyException {
        if(topIndex==-1){
            //Throw stackEmpty expection
            throw new StackEmptyException();
        }
        int temp=data[topIndex];
        topIndex--;
        return temp;
    }


}
