/*A sorted(in ascending order) array A[ ] with distinct elements is rotated at some unknown point,
the task is to find the minimum element in it.

        Example 1

        Input:
        N = 5
        arr[] = {4 ,5 ,1 ,2 ,3}
        Output: 1
        Explanation: 1 is the minimum element inthe array*

        /
 */

package com.SDESheet.BinarySearch.Arrays_1D;

public class FindMiniumumInRotatedSortedArray {

    int findMin(int arr[], int n)
    {
        int low = 0, high = arr.length - 1, ans= Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) /2 ;

  /*        now will  check which side is sorted and will perform our check only on that side
            here check will be whichever side is sorted will pick its lowest element
            in left side it will be lowest in that space  , and  on right side it will be mid
            and then check whether that low against ans;*/

            //we are using sorted property

            // if left is sorted
            if (arr[low] <= arr[mid]) {
                //once you performed check on left side , eliminate left side
                //and move searching space to right hand side
                ans=Integer.min(ans,arr[low]);
                low=mid+1;
            } else
            // if right is sorted
            {
                ans=Integer.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }


    //slightly better optimised , otherwise above solution is also okay
    int findMin_optimised(int arr[], int n)
    {
        int low = 0, high = arr.length - 1, ans= Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) /2 ;

            /*if the serach space is alrady sorted then  always low be smallest in that space
            * then why need to perform binary search again and again on that space */
            if (arr[low] <= arr[high]) {
                ans=Integer.min(ans,arr[low]);
                break;
            }


  /*        now will  check which side is sorted and will perform our check only on that side
            here check will be whichever side is sorted will pick its lowest element
            in left side it will be low , and right side it will be mid
            and then check whether that low against ans;*/

            // if left is sorted
            if (arr[low] <= arr[mid]) {
                //once you performed check on left side , eliminate left side
                //and move searching space to right hand side
                ans=Integer.min(ans,arr[low]);
                low=mid+1;
            } else
            // if right is sorted
            {
                ans=Integer.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {


    }
}
