package com.PriorityQueues;

/*
Approach 1 : Bruteforce
Create an output array of size (N * K) and then copy all the elements into the output array followed by sorting.
1.Create an output array of size N * K.
2.Traverse the matrix from start to end and insert all the elements in the output array.
3.Sort and print the output array.

* */


/*
* Approach 2;
1. Create min heap and push every first element of each array in that heap.
* 2.create  a ans array to store final answer
* 3.get the min of heap and put in ans array.
* 4.insert the next element of same array in the heap if present
* 5.repeat the process till heap.size >0;
*
* */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class node {
    int data;
    int row;
    int column;

    public node (int data,int row,int column){
        this.data=data;
        this.row=row;
        this.column=column;
    }
}

//class  PqComparator implements Comparator<node>
//{
//    public int compare(node pair1, node pair2)
//    {
//        return pair1.data - pair2.data;
//    }
//}


public class Merge_K_Sorted_Arrays {


    public static ArrayList<Integer> mergeKSortedArrays(int[][] kArrays, int k)
    {
        //create the min heap

        PriorityQueue<node> pq = new PriorityQueue<>((n1, n2) -> n1.data - n2.data);

        //Step 1: insert all first element of array
        for(int i=0; i < kArrays.length ;i++){
            node temp=new node(kArrays[i][0],i,0);
            pq.add(temp);
        }

        //create a ans array
        ArrayList<Integer> ans=new ArrayList<>();

        //step 2:
        while(!pq.isEmpty()){
             //put top element in ans array
            node temp=pq.poll();
            ans.add(temp.data);
//            pq.poll();

            //now put next element of same array in heap
            int i=  temp.row;
            int j = temp.column;

            //checking so that next element exists of that array
            //if exist , push that in heap
            if(j+1 < kArrays[i].length){
                node next=new node(kArrays[i][j+1],i,j+1);
                pq.add(next);
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        int[][] arr={{3,5,9},{1,2,3,8}};
        ArrayList<Integer> ans =mergeKSortedArrays(arr,2);
        for(int i : ans){
            System.out.println(i);
        }



    }

}
