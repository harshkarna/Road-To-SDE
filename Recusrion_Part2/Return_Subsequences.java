//Input : "xyz"
//        Output :
//        " "
//        x
//        y
//        z
//        xy
//        yz
//        xz
//        xyz


package com.Recusrion_Part2;

public class Return_Subsequences {

    public static  String[] printSubsequences(String str){
        if(str.length()==0){
            String ans[]={" "}; //is there any other way to do
            return ans;
        }

        String smallcase[]= printSubsequences(str.substring(1)); //let recusrion do yz work
        String ans[] =new String[smallcase.length *2 ]; //as we know that final answer is double of length work done by smallcase


        int k =0;
        for (int i=0; i<smallcase.length;i++){ //copying smallcase work in final ans
            ans[k]=smallcase[i];
            k++;
        }

        for (int i=0;i<smallcase.length;i++){    // copying again but now appending fisrt char of str with each and every work of smallcase
            ans[k]=str.charAt(0) +smallcase[i];  // ans[i+small.length]
            k++;
        }

        return ans;

    }

    public static void main(String[] args) {
       String str ="xyz";
       String final_ans[]=printSubsequences(str);
       for(String i: final_ans){
           System.out.println(i);
       }
    }

}
