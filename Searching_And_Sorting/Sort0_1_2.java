package com.Searching_And_Sorting;

public class Sort0_1_2 {

    //best approach
    
    public static void sort012(int arr[]) {
        int nz = 0;
        int nt = arr.length - 1;
        int i=0;

        while(i<=nt){
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[nz];
                arr[nz] = temp;
                nz++;
                i++;

            }
            else if (arr[i] == 2) {
                    int temp = arr[i];
                    arr[i] = arr[nt];
                    arr[nt] = temp;
                    nt--;
                }
            else{
                i++;
            }
        }

        //display of array
        for(int k=0;k < arr.length; k++){
            System.out.print(arr[k]+" ");
        }

    }

        public static void main(String[] args) {
            int arr[]={0,1,2,1,2,1,2};
            sort012(arr);

    }
}
