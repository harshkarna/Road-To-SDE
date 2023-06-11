/*Given an unsorted array Arr of size N of positive integers. One number
 'A' from set {1, 2,....,N}
is missing and one number 'B' occurs twice in array. Find these two numbers.

        Example 1:
        Input:
        N = 2
        Arr[] = {2, 2}
        Output: 2 1
        Explanation: Repeating number is 2 and
        smallest positive missing number is 1.
        Example 2:

        Input:
        N = 3
        Arr[] = {1, 3, 3}
        Output: 3 2
        Explanation: Repeating number is 3 and
        smallest positive missing number is 2.
        */
package com.SDESheet.Arrays.Hard;

import java.util.Arrays;
import java.util.HashMap;

public class FindReapeatingAndMissingNumbers {


    /*
    Brute Force 1
    check i from 1 to N , TO(n2)
    * */
    public static int[] findTwoElement(int arr[], int n) {
        //failing in GFG need to see
        int[] ans=new int[2];
        int count=0;
        int repeating=-1;
        int missing =-1;
        for(int i=1; i <=n ;i++){
            count=0;
            for(int j=0; j < n; j++){
                if(arr[j]==i){
                    count++;
                }
            }
            if(count==2){
//                repeating=i;
                ans[0]=i;
            }
            else if(count==0)
            {
//                missing=i;
                ans[1]=i;
            }
//            if(repeating!=-1 && missing!=1){
//                break;
//            }
        }
        return ans;
    }


    /*Approach 2

    //Failing for test cases
    Use Sorting
    1.Sort the input array.
    2.Traverse the array and check for missing (if i =! arr[i-1]
     and repeating by checking if i+1 is sam eor not

    *
    * */
    public static int[] findTwoElement_V2(int arr[], int n) {
        // sorting the array
        int[] ans=new int[2];
        Arrays.sort(arr);
//        System.out.print("The repeating element is ");
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
               ans[0]=arr[i];
                break;
            }
        }

//        System.out.print("and the missing element is ");
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                ans[1]=i;
                break;
            }
        }
        return ans;
    }


    /*Approach 3:
    Using check Array
    Time Complexity: O(N)
     Space Complexity: O(N) As we are making new substitute array
    *
    * */
    public static int[] findTwoElement_V3(int arr[], int n) {
        int[] substitute = new int[n+1]; // initializing the substitute array
        // with 0 of size n+1.
        for (int i = 0; i < n; i++)
            substitute[i] = 0;

        int[] ans=new int[2];             // initializing the answer  array .

        for (int i = 0; i < n; i++) {
            substitute[arr[i]]++;
        }

        for (int i = 1; i <=n; i++) {
            if (substitute[i] > 1 ) {
               ans[0]=i;
            }
            else if(substitute[i] == 0 ){
                ans[1]=i;
            }
        }
        return ans;
    }

    /*
    *Approach 4 : Using hashmap
    * not working , instead of hashap better to use hash array as did in approach 3
    * Create an hashmap of size arr.length+1 as we need to find i from 1 to 6
    *
    * */

    public static int[] findTwoElement_V4(int arr[], int n) {
        // code here

        int [] result = new int [2];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i=1;i<=n;i++){
            //means that i is not present
            if(map.get(i)==0){
                result[1] = i;
            }
            if(map.get(i) > 1){
                result[0] = i;
            }
        }

        return result;
    }




    public static void main(String[] args) {
        int[] arr ={1,2,3,2};
        int[] ans=findTwoElement_V2(arr, arr.length);
        for(int i : ans){
            System.out.print(i +" ");
        }




    }
}
