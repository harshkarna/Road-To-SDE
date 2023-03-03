package com.PriorityQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSubArray {
    /*
    Approach 1 : Brute force
    1.Run 2 loops , i and j, and make every sum possible  for the subarray.
    2.store the sum of every subarray in  a arraylist, and then sort the arraylist
    3.return  length- k / kth element from last.
    problem is tc=n2logn, which can be improved
    */
    public static  int getKthLargest(ArrayList<Integer> arr, int k){
        ArrayList<Integer> sumStore=new ArrayList<>();

        for(int i=0;i < arr.size();i++){
            int sum=0;
            for(int j=i;j <arr.size();j++){
                sum+=arr.get(j);
                sumStore.add(sum);
            }
        }

        Collections.sort(sumStore);
        return sumStore.get(sumStore.size()-k);

    }

    /*
    Approach 2: Using Priority queue
    1.Create a min heap in starting / same analogy as we have done for kth largest number
    2. Run 2 loops , i and j
    3,now inside j loop , push firts k  values in heap , and again do the same thing we did in kth largets

    * */
    public static  int getKthLargestv2(ArrayList<Integer> arr, int k){
        //creating min heap
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i < arr.size();i++){
            int sum=0;
            for(int j=i;j <arr.size();j++){
                sum+=arr.get(j);
                if(pq.size() < k){
                    pq.add(sum);
                }
                else{
                    if(pq.peek() < sum){
                        pq.poll();
                        pq.add(sum);
                    }
                }
            }
        }
        return pq.peek();

    }


    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        int k =2;
        arr.add(4);
        arr.add(1);
//        arr.add(5);
        System.out.println(getKthLargestv2(arr,k));

    }
}
