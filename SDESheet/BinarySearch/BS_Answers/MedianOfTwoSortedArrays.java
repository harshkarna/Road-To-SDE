package com.SDESheet.BinarySearch.BS_Answers;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] a=nums1;
            int[] b =nums2;
            // Size of two given arrays
            int n1 = a.length;
            int n2 = b.length;

            List<Integer> arr3 = new ArrayList<>();
            // Apply the merge step
            int i = 0, j = 0, k = 0;
            while (i < n1 && j < n2) {
                if (a[i] < b[j]) {
                    arr3.add(a[i++]);
                } else {
                    arr3.add(b[j++]);
                }
            }

            // Copy the left-out elements
            while (i < n1) {
                arr3.add(a[i++]);
            }
            while (j < n2) {
                arr3.add(b[j++]);
            }

            // Find the median
            int n = n1 + n2;
            if (n % 2 == 1) {
                return (double) arr3.get(n / 2);
            }

            double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
            return median;
        }

    public static void main(String[] args) {


    }
}
