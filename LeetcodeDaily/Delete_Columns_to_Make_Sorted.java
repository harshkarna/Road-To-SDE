package com.LeetcodeDaily;

public class Delete_Columns_to_Make_Sorted {
    public static int minDeletionSize(String[] strs) {
        // Initialize the delete count to 0
        int rowsToDelete=0;

        int m =strs[0].length();
        int n =strs.length;

        // i is for every char of each string in array
        for(int i=0; i< m ;i++){
            // j is for traverse over each string in array
            for(int j=1;j<n;j++){
                // If the current element is lexicographically smaller
                // than the previous element,
                // increment the delete count and break out of the loop
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    rowsToDelete++;
                    break;
                }
            }
        }
        return rowsToDelete;


    }

    public static void main(String[] args) {
       String[] strs = {"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));

    }
}
