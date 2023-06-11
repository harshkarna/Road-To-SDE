/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.



        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

*/

package com.SDESheet.Arrays.Hard;

import java.util.*;

public class ThreeSum {

    //Brute Force
    //lets find out all the triplets , need 3 loops
    //TO(n^3) --Bad
    public static List<List<Integer>> threeSum_Brute(int[] nums) {
        //using set to remove duplicates
        Set<List<Integer>> set=new HashSet<>();
        int n =nums.length;
        for (int i=0; i < n ; i++){
            for( int j=i+1; j < n ;j++){
                for(int k =j+1;j< n;j++){
                    if(nums[i] +nums[j] +nums[k] ==0){
                        //once you found the triplet , add them to a tmp list
                         List<Integer> temp=new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            //Sort that temp list , and store in set , to avoid duplicates
                            Collections.sort(temp);
                            set.add(temp);

                    }
                }
            }
        }
//        return new ArrayList<>(set);
        List<List<Integer>> ans=new ArrayList<>();
        //at last add all your set values in ans list
        ans.addAll(set);
        return ans;
    }



    /*
    Will us hashing , same concept as we did in 2 sum
    1.we need to find i + j + k =0
    2.we will find k = - (i+j) , if k is present i hashmap , we found our triplet \
    3. But we need to take we should not choose k as i or j as i!=k!=j
    4. So will have 2 pointer i and j starting just next to i , and will keep increasing j till end
    and whatever its in between i and j will put in hashmap, and will the k = - (i+j) during 1 traversal .
    5.like that in next traversal we will move i by 1 and keep j just next to i , and repeat the same process
    just make sure to empty your hashmap everytime new ith traversal starts

    //TO(n^2) * log n  -- log n because we are using set and its size changing everytime

    * */

    public static List<List<Integer>> threeSum_Better(int[] nums) {
        //using set to remove duplicates
        int n =nums.length;

        Set<List<Integer>> ansSet=new HashSet<>();
        for (int i=0; i < n ; i++){
            Set<Integer> set=new HashSet<>();
            for( int j=i+1; j < n ;j++){
                int third= -(nums[i] +nums[j]);
                if(set.contains(third)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    ansSet.add(temp);

                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ansSet);
    }


    /*
    //Optimal Approach
    1. Sort the array first.
    2. Apply 2 pointer approach .
    3.First fix the i , initially i will be at 0 and j just next to i and keep k at the end .
    4.Now add up i , j and k and see if sum < 0 , as array is sorted , we need to increase j to increase overall value .
    5. if sum is > 0 , means we need to decrease overall value so we will decrement k .
    we are doing around 0 because question says i +j+k should be 0 .
    6. and while moving j and k , if you find triplet , store it and as array is sorted so triplet will also \
    be in sorted order.
    7.Now one thing to note , while moving i , j and k , move them so that its value is different from its previous value
    8.Once j crosses k, no point then , stop that traversal , and move i to next position.


    To(n logn+ n2)
    SO(almost constant)
    * */

    public static List<List<Integer>> threeSum_Optimal(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n =nums.length;
        for (int i=0; i < n ; i++){
            //checking cond for i from 2nd as 1 st have no previous and if i is
            //same as previous keep moving i
            if(i > 0 && nums[i]==nums[i-1]) continue;

            int j=i+1;
            int k=n-1;

            while(j < k ){
                int sum =nums[i] +nums[j] +nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    //found the triplet
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j]==nums[j-1]) j++;
                    while(j < k && nums[k]==nums[k+1]) k--;

                }
            }


        }
        return ans;
    }



    public static void main(String[] args) {



    }
}
