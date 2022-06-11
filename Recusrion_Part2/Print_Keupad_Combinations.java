//Print Keypad Combinations Code
//
//        Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
//        Note : The order of strings are not important. Just print different strings in new lines.
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

public class Print_Keupad_Combinations {

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

    public static void keypad(int n, String outputsofar){

        if (n==0){
            System.out.println(outputsofar);
            return ;
        }
        String[] options=singleDigit(n%10); //take all options in String array

        for(int i=0;i<options.length;i++){
            keypad(n/10,options[i] + outputsofar); //one by one attach all options in output so far
        }

    }

    public static void keypad(int n){

        keypad(n,"");
    }

    public static void main(String[] args) {

        keypad(23);

    }
}
