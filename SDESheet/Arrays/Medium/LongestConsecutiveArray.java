/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

        You must write an algorithm that runs in O(n) time.
        Example 1:

        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
         Therefore its length is 4.
*/

package com.SDESheet.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveArray {


/*Approach :Better By Sorting
    Approach: We can simply sort the array and run a for
    loop to find the longest consecutive sequence.

    Time Complexity: We are first sorting the array which will take O(N * log(N)) time and
    then we are running a for loop which will take O(N) time. Hence, the overall time complexity
    will be O(N * log(N)).
    Space Complexity: The space complexity for the above approach is O(1) because we are not
    using any auxiliary space
*
* */
    private static int getLongestConsecutiveArray(int[] arr) {

        //Sort the array
        Arrays.sort(arr);
       int currentCount=1;
       int previous=arr[0];
       int maxCount=0;

       for(int i=1; i < arr.length;i++){
           //if its a consecutive value ,means just next
           if(arr[i]==previous + 1 ){
               currentCount++;
           } 
           //this is to check if current value altogether different sequence
           //if yes then just make count to 1 again
           else if (arr[i] != previous){
              currentCount=1;
           }

           //make the current i as prev before going ahead
           previous=arr[i];
           maxCount=Math.max(maxCount, currentCount);

       }
       return maxCount;
    }

    /*
    * Approach: Optimal
    * We will first push all elements in the HashSet. Then we will run a for
    * loop and check for any number(x) if it is the starting number of the consecutive
    * sequence by checking if the HashSet contains (x-1) or not. If ‘x’ is the starting
    * number of the consecutive sequence we will keep
    * searching for the numbers y = x+1, x+2, x+3, ….. And stop at the first ‘y’ which
    * is not present in the HashSet. Using this we can calculate the length of the
    * longest consecutive subsequence.*/


    /*
    Time Complexity: The time complexity of the above approach is O(N)
    because we traverse each consecutive subsequence only once.
    (assuming HashSet takes O(1) to search)
    Space Complexity: The space complexity of the above approach is
    O(N) because we are maintaining a HashSet.
    */

    public static int longestConsecutive(int[] nums) {
        HashSet < Integer > hashSet = new HashSet < Integer > ();
        //add the array elements in Set, this will remove dupes
        for (int num: nums) {
            hashSet.add(num);
        }
        int longestStreak = 0;
        //now you can  iterate over array or set
        for (Integer num: hashSet) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {

        int[] arr={100,4,200,1,3,2};
        System.out.println(getLongestConsecutiveArray(arr));

    }


}
