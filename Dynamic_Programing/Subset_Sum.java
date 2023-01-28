/*Subset Sum

        You are given a set of N integers. You have to return true if there exists a subset that sum up to K,
        otherwise return false.
        Input Format
        The first line of the test case contains an integer 'N' representing the total elements in the set.

        The second line of the input contains N integers separated by a single space.

        The third line of the input contains a single integer, denoting the value of K.
        Output Format
        Output Yes if there exists a subset whose sum is k, else output No.
        Constraints :
        1 <= N <= 10^6
        1 <= a[i] <= 10^3, where a[i] denotes an element of the set
        1 <= K <= 10^3

        Time Limit: 1 sec
        Sample Input 1 :
        4
        4 3 5 2
        13
        Sample Output 1 :
        No
        Sample Input 2 :
        5
        4 2 5 6 7
        14
        Sample Output 2 :
        Yes
        */

package com.Dynamic_Programing;

public class Subset_Sum {
    private static boolean isSubsetPresentRecusrsive(int[] arr,int index ,int target) {
        if(target ==0){
            return true;
        }
        if (index ==0){
            return arr[index]==target ;

        }

        boolean notTake= isSubsetPresentRecusrsive(arr,index-1,target);
        boolean take =false;
        if(target >= arr[index]){
            take=isSubsetPresentRecusrsive(arr,index-1,target-arr[index]);
        }

        return notTake || take;
    }

    public static void main(String[] args) {

        int[] arr={4,3,5,2};
        int n= arr.length;
        int target=13;
        System.out.println(isSubsetPresentRecusrsive(arr,n-1,target));

    }

}
