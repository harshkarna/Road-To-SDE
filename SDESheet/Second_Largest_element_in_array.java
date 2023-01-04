package com.SDESheet;

public class Second_Largest_element_in_array {

    int print2largest(int arr[], int n) {
        int l=arr[0]; //assume 1st elemt of array as largest

        int sl =-1;
        for(int i=1;i<n;i++){
            if(arr[i]>l){
                sl=l;
                l=arr[i];
            }
            else if(arr[i]<l && arr[i]>sl){ //for case if a[i] is less than l but greater than sl
                sl=arr[i];
                sl++;
                sl++;
            }
        }
        return sl;

    }

}
