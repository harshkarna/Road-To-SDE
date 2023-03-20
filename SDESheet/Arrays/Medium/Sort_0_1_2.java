package com.SDESheet.Arrays.Medium;

public class Sort_0_1_2 {
    /*
    Approach1 : Brute force
    Do sorting nlogn

    Approach2 : Count no of 0s 1s and 2s and fill another array
    with the counts
    but you will use space here


    Approach3 : Dutch National Flag Algorithm
    Pointer based approach
    * */

    //best approach
    //Dutch National Flag Algorithm
    //To=(N)
    //So(1)

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
                //will move i and nz both as we know after swapping it have to be 1 at i

            }
            else if (arr[i] == 2) {
                int temp = arr[i];
                arr[i] = arr[nt];
                arr[nt] = temp;
                nt--;
                //remember we will not move i, as we haven't process 2nd half of the array
            }
            else{
                //when arr[i] is 1 , just move i++
                i++;
            }
        }

        //display of array
        for(int k=0;k < arr.length; k++){
            System.out.print(arr[k]+" ");
        }

    }

    public static void main(String[] args) {
        int arr[]={0,1,2,0,2,0,2};
        sort012(arr);

    }
}
