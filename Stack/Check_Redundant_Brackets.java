//Check redundant brackets
//
//        For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that
//        the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
//        A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
//        Example:
//        Expression: (a+b)+c
//        Since there are no needless brackets, hence, the output must be 'false'.
//
//        Expression: ((a+b))
//        The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
//        Note:
//        You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
//        Input Format :

//        The first and the only line of input contains a string expression, without any spaces in between.
//        Output Format :
//        The first and the only line of output will print either 'true' or 'false'(without the quotes) denoting whether the input expression contains redundant brackets or not.
//        Note:
//        You are not required to print the expected result. It has already been taken care of.
//        Constraints:
//        0 <= N <= 10^6
//        Where N is the length of the expression.
//
//        Time Limit: 1 second
//        Sample Input 1:
//        a+(b)+c
//        Sample Output 1:
//        true
//        Explanation:
//        The expression can be reduced to a+b+c. Hence, the brackets are redundant.
//        Sample Input 2:
//        (a+b)
//        Sample Output 2:
//        false

package com.Stack;

import java.util.Stack;

public class Check_Redundant_Brackets {

    public static boolean checkRedundantBrackets(String exp){
        Stack<Character> stack=new Stack<>();
        int count=-1;

        for(int i=0; i<exp.length();i++){

            //if its opening bracket or some useful info operator
            if(exp.charAt(i)!=')'){
                stack.push(exp.charAt(i));
            }
            else {
                //So once you encounter a closing bracket ,trace the stack till yoi get opening bracket
                //and count the useful information between and pop those simultaneously till opening bracket
                while(stack.peek()!='('){
                    stack.pop();
                    count++;
                }
                //If the count is more than 0 then pop the opening bracket
                //and set count and move to next i.
                if(count > 0){
                    count =0;
                    stack.pop();
                    continue;
                }
                //if you get count =0, that means this is redundant pair ,
                //So return true at this point of time
                else if (count==0) {
                    return true ;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String exp="((a+b))";
        boolean answer=checkRedundantBrackets(exp);
        System.out.println(answer);


    }
}
