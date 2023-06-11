/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

        0 <= a, b, c, d < n
a, b, c, and d are distinct.
        nums[a] + nums[b] + nums[c] + nums[d] == target
        You may return the answer in any order.



        Example 1:

        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        */
package com.SDESheet.Arrays.Hard;

import java.util.*;

public class FourSum {


    /*Brute force ---
    1.use 4 loops , i , then , j , and k
    2. once find quad , sort it and then store in a set to avoid duplicates
    3.To(n4)--which is bad
    * */

    public ArrayList<ArrayList<Integer>> fourSum_Brute(int[] arr, int target) {
        //using set to remove duplicates
        Set<ArrayList<Integer>> set=new HashSet<>();
        int n =arr.length;
        for (int i=0; i < n ; i++){
            for( int j=i+1; j < n ;j++){
                for(int k =j+1;k< n;k++){
                    for(int l =k+1;l<n;l++) {
                        if (arr[i] + arr[j] + arr[k] +arr[l] == target) {
                            //once you found the triplet , add them to a tmp list
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[l]);
                            //Sort that temp list , and store in set , to avoid duplicates
                            Collections.sort(temp);
                            set.add(temp);

                        }
                    }
                }
            }
        }
//        return new ArrayList<>(set);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        //at last add all your set values in ans list
        ans.addAll(set);
        return ans;
    }


    /*
    Will us hashing , same concept as we did in 2 sum
    1.we need to find i + j + k +l =target
    2.we will find l = - (i+j+k) , if l is present i hashmap , we found our triplet \
    3. But we need to take we should not choose k as i or j as i!=k!=j=!l
    4. So will have 2 pointer  contact i and j and l starting just next to j  , and will keep increasing j till end
    and whatever its in between l and k will put in hashmap, and will the k = - (i+j) during 1 traversal .
    5.like that in next traversal we will move i by 1 and keep j just next to i , and repeat the same process
    just make sure to empty your hashmap everytime new ith traversal starts

    //TO(n^2) * log n  -- log n because we are using set and its size changing everytime

    * */

    public ArrayList<ArrayList<Integer>> fourSum_Beter(int[] arr, int target) {
        //using set to remove duplicates
        int n =arr.length;

        Set<ArrayList<Integer>> ansSet=new HashSet<>();
        for (int i=0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target - (arr[i] + arr[j] +arr[k]);
                    if (set.contains(fourth)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(fourth);
                        Collections.sort(temp);
                        ansSet.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(ansSet);
    }

     /*
    //Optimal Approach
    1. Sort the array first.
    2. Apply 2 pointer approach .
    3.First fix the i , and j  , initially i will be at 0 and j just next to i and  and l  next to j  and keep k at the end .
    4.Now add up i , j, l  and k and see if sum < 0 , as array is sorted , we need to increase j to increase overall value .
    5. if sum is > 0 , means we need to decrease overall value so we will decrement k .
    we are doing around 0 because question says i +j+k should be 0 .
    6. and while moving j and k , if you find quad , store it and as array is sorted so triplet will also \
    be in sorted order.
    7.Now one thing to note , while moving i , j and k , move them so that its value is different from its previous value
    8.Once j crosses k, no point then , stop that traversal , and move i to next position.


    To(n logn+ n2)
    SO(almost constant)
    * */


    public ArrayList<ArrayList<Integer>> fourSum_Optimal(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int n =arr.length;
        for (int i=0; i < n ; i++){
            //checking cond for i from 2nd as 1 st have no previous and if i is
            //same as previous meep moving i
            if(i > 0 && arr[i]==arr[i-1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1]) continue;
                int m=j+1;
                int l=n-1;
                while(m < l){
                    int sum =arr[i] +arr[j] +arr[m] + arr[l];
                    if(sum ==k){
                        //found the quad
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[m]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        m++;
                        l--;
                        while(m < l && arr[m]==arr[m-1]) m++;
                        while(m < l && arr[l]==arr[l+1]) l--;
                    }
                    else if(sum < k){
                        m++;
                    }
                    else{
                        //sum < 0
                        l--;
                    }

                }

            }

        }
        return ans;
    }



    public static void main(String[] args) {



    }
}
