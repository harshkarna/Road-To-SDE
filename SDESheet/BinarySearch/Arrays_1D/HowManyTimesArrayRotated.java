/*Given an ascending sorted rotated array Arr of distinct integers of size N.
The array is right rotated K times. Find the value of K.

        Example 1:

        Input:
        N = 5
        Arr[] = {5, 1, 2, 3, 4}
        Output: 1
        Explanation: The given array is 5 1 2 3 4.
        The original sorted array is 1 2 3 4 5.
        We can see that the array was rotated
        1 times to the right.*/

package com.SDESheet.BinarySearch.Arrays_1D;

public class HowManyTimesArrayRotated {

    static int findKRotation_try(int arr[]) {

        int low = 0, high = arr.length - 1, ans= Integer.MAX_VALUE, index=-1;

        while (low <= high) {

            int mid = (low + high) /2 ;

            /*if the serach space is alrady sorted then  always low be smallest in that space
             * then why need to perform binary search again and again on that space */
            if (arr[low] <= arr[high]) {
                if(arr[low] < ans){
                    index=low;
                    break;
                }

            }

  /*        now will  check which side is sorted and will perform our check only on that side
            here check will be whichever side is sorted will pick its lowest element
            in left side it will be lowest in that space  , and  on right side it will be mid
            and then check whether that low against ans;*/


            //we are using sorted property

            // if left is sorted
            if (arr[low] <= arr[mid]) {
                //once you performed check on left side , eliminate left side
                //and move searching space to right hand side
                if(arr[low] < ans){
                    index=low;
                    ans=Integer.min(ans,arr[low]);
                }
                low=mid+1;
            } else
            // if right is sorted
            {
                if(arr[mid] < ans){
                    index=mid;
                    ans=Integer.min(ans,arr[mid]);
                }
                high=mid-1;
            }
        }
        return index;

    }

    public static void main(String[] args) {
//        int arr[]={ 5,1,2,3,4};
        int arr[]={66,67,7, 10 ,14 ,19,21};
        System.out.println(findKRotation_try(arr));


    }

}
