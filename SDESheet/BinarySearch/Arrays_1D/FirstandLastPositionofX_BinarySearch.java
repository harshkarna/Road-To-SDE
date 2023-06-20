package com.SDESheet.BinarySearch.Arrays_1D;

import java.util.ArrayList;

public class FirstandLastPositionofX_BinarySearch {

    public static int firstOccurenec(int n, int key, long[] v) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid =(low+high)/2;
            if (v[mid] == key) {
                ans = mid;
                high = mid - 1;

            } else if ( v[mid] < key ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;
    }

    public static int lastOccurenec(int n, int key, long[] v) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid =(low+high)/2;

            if (v[mid] == key) {
                ans = mid;
                low = mid +1;

            } else if ( v[mid] < key ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> ans=new ArrayList<Long>();
        long first=firstOccurenec(n,x,arr);
        if(first== -1) {
//            ans.add(-1);
//            ans.add(-1);
            return ans;
        }

        long last=lastOccurenec(n,x,arr);
        ans.add(first);
        ans.add(last);
        return ans;

    }
    public static void main(String[] args) {

    }
}
