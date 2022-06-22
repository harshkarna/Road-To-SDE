package com.OOPS_part1;

public class DynamicArray {

    private int data[];
    private int nextElementIndex;

    //when default constructor is called
    public DynamicArray(){
        data=new int[5];
        nextElementIndex=0;
    }

    public void add(int i){
        if(nextElementIndex==data.length){
            doubleCapacity();
        }
        data[nextElementIndex]=i;
        nextElementIndex++;
    }

    //doubling the capacity of existing array when the pointer reached end of the array
    private void doubleCapacity(){
        int temp[]=data;
        data=new int[2 * temp.length];
        for (int i=0;i<temp.length;i++){
            data[i]=temp[i];
        }
    }

    //setting ith index with a value
    public void set(int i, int value){
        if (i > nextElementIndex){
            //Throw error
            return;
        }
         data[i]=value;
    }

    //getting length of array created till now
    public void size(){
        System.out.println( nextElementIndex);
    }

    //to check whether array is empty or not
    public boolean isEmpty(){
        return nextElementIndex==0;
    }


    //to get data from particular index
    public int get(int i){
        if(i > nextElementIndex){
            return -1;
        }
        return data[i];

    }



}
