package com.Recursion.Striver;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {


        public static void generateSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
            if (index == arr.length) {
                // Base case: Add the current subsequence to the result list
                result.add(new ArrayList<>(current));
                return;
            }

            // Include the current element in the subsequence
            current.add(arr[index]);
            generateSubsequences(arr, index + 1, current, result);
            current.remove(current.size() - 1); // Backtrack

            // Exclude the current element from the subsequence
            generateSubsequences(arr, index + 1, current, result);
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3};
            List<List<Integer>> subsequences = new ArrayList<>();
            generateSubsequences(arr, 0, new ArrayList<>(), subsequences);

            for (List<Integer> subsequence : subsequences) {
                System.out.println(subsequence);
            }
        }
    }


