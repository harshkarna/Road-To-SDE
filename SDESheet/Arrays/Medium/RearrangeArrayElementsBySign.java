/*
You are given a 0-indexed integer array nums of even length consisting of an equal number of
 positive and negative integers.

        You should rearrange the elements of nums such that the modified array follows the given conditions:

        Every consecutive pair of integers have opposite signs.
        For all integers with the same sign, the order in which they were present in nums is preserved.
        The rearranged array begins with a positive integer.
        Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

        Example 1:

        Input: nums = [3,1,-2,-5,2,-4]
        Output: [3,-2,1,-5,2,-4]
        Explanation:
        The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
        The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
        Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not
        satisfy one or more conditions.
*/

package com.SDESheet.Arrays.Medium;

public class RearrangeArrayElementsBySign {

    /* Approach : Variety 1
    Create a extra space , will store our result there .
    As we know positive numbers needs to start the modified array
    so lets have 2 pointer , pos will start from 0 and neg will start from 1 ,
    and just increment them by 2 .keep iterating till end of the array.

    Note : This approach will only work if positive numbers are equal to negative
*
* */
    private static int[] getRearrangeArrayElementsBySign(int[] arr){
        //Note : This approach will only work if positive numbers are equal to negative
        //have an extra sapce to return result
        int output[]=new int[arr.length];
        int n =arr.length;
        //pos will start from 0 and negative will start from 1
        int positive_index=0;
        int negative_index=1;

        for(int i=0;i<n ;i++){
            if(arr[i] > 0 ){
                //if positive
                output[positive_index]=arr[i];
                positive_index+=2;
            }
            if(arr[i]<0){
                //if negative
                output[negative_index]=arr[i];
                negative_index+=2;
            }
        }
        return output;
    }


    /*Approach : its actually brute force , will work for variety 1 also
    Variety 2 : Here it can be positive number count not equal to
    negative number count.
    Storing pos and negative in separate array.
    Here we can have positive and negative elements stored in separate 2 arrays
    with their respective order.


    * */
    private static int[]  getRearrangeArrayElementsBySign_v1(int[] arr){
        //count the pos and negative , so that we can create arrays
        int pos_length=0;
        int k=0;
        int neg_length=0;
        int m=0;
        for(int i : arr){
            if(i >= 0){
                pos_length++;
            }
            else{
                neg_length++;
            }
        }

       // Step 2 :  Collect the positive and negative
        int[] positive =new int[pos_length];
        int[] negative =new int[neg_length];
        for(int i : arr){
            if(i >= 0){
                positive[k]=i;
                k++;
            }
            else{
                negative[m]=i;
                m++;
            }
        }
        //Step 3:
        //NoW lets handle the case where pos_length!=neg_length
        //now first  handle the common number counts , then we
        //will handle the extra on e
        if(pos_length > neg_length){
            for(int i=0; i < neg_length;i++){
                arr[2*i]=positive[i];
                arr[2*i+1]=negative[i];
            }
            //now lets copy the extra values left
            //index is where to start filling extra values
            int index =neg_length*2;
            for(int i=neg_length;i < pos_length;i++) {
                arr[index]=positive[i];
                index++;
            }
        }
        else
        {
            for(int i=0; i < pos_length;i++){
                arr[2*i]=positive[i];
                arr[2*i+1]=negative[i];
            }
            //now lets copy the extra values left
            //index is where to start filling extra values
            int index =pos_length*2;
            for(int i=pos_length;i < neg_length;i++) {
                arr[index]=negative[i];
                index++;
            }

        }
        return arr;
    }



    public static void main(String[] args) {
        int[] arr={3,1,-2,-5,2,-4};
//        int[] result=getRearrangeArrayElementsBySign(arr);
//        for(int i : result){
//            System.out.print(i +" ");
//        }

        int[] result=getRearrangeArrayElementsBySign_v1(arr);
        for(int i : result){
            System.out.print(i +" ");
        }



    }
}
