//
//Input :{1,4,7,6,5};
//Output :
//        (1,4)
//        (1,7)
//        (1,6)
//        (1,5)
//        (4,7)
//        (4,6)
//        (4,5)
//        (7,6)
//        (7,5)
//        (6,5)
//


package com.Array;

public class PrintPairs {

    public static void main(String[] args) {

        int arr[]= {1,4,7,6,5};

        for(int i=0;i< arr.length;i++){

            for(int j=i+1;j< arr.length;j++){
                System.out.println("(" +arr[i]+ "," +arr[j]+ ")");
            }
        }


    }
}
