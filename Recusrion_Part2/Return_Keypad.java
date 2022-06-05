//Return Keypad Code
//
//        Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
//        Return empty string for numbers 0 and 1.
//        Note : 1. The order of strings are not important.
//        2. Input and output has already been managed for you. You just have to populate the output array and return the
//        count of elements populated in the output array.
//        Input Format :
//        Integer n
//        Output Format :
//        All possible strings in different lines
//        Constraints :
//        1 <= n <= 10^6
//        Sample Input:
//        23
//        Sample Output:
//        ad
//        ae
//        af
//        bd
//        be
//        bf
//        cd
//        ce
//        cf

package com.Recusrion_Part2;

public class Return_Keypad {
    public static String[] singleDigit(int n ){

        if(n==2){
            String output[]={"a","b","c"};
            return output;
        }
        else if (n==3){
            String output[]={"d","e","f"};
            return output;
        }
        else if (n==4){
            String output[]={"g","h","i"};
            return output;
        }
        else if (n==5){
            String output[]={"j","k","l"};
            return output;
        }
        else if (n==6){
            String output[]={"m","n","o"};
            return output;
        }
        else if (n==7){
            String output[]={"p","q","r","s"};
            return output;
        }
        else if (n==8){
            String output[]={"t","u","v"};
            return output;
        }
        else if (n==9){
            String output[]={"w","x","y","z"};
            return output;
        }
        else{
            String output[]={" "};
            return output;
        }

    }

    public static String[] keypad(int n){
        if(n==0){
            String output[]={" "};
            return output;
        }
        String smallNumberArray[]=keypad(n/10);
        String singleDigitOutput[]=singleDigit(n%10);
        String output[] = new String[singleDigitOutput.length * smallNumberArray.length];

        int k=0;
        for(int i =0 ;i < singleDigitOutput.length;i++){
            for(int j=0;j< smallNumberArray.length;j++){
                output[k]=smallNumberArray[j]+singleDigitOutput[i];
                k++;
            }
        }
        return output;
    }

    public static void main (String[] args){
        int n =73;
        String final_arr[]=keypad(n);
        for(String i:final_arr){
            System.out.println(i);
        }

    }

}
