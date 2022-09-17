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

public class Check_Redundant_Brackets_1 {

    //Best Solution

    public static boolean checkRedundantBrackets(String exp){
        Stack<Character> stack=new Stack<>();

        for(int i=0; i<exp.length();i++){

            //if its opening bracket or some useful info operator
            if(exp.charAt(i)!=')'){
                stack.push(exp.charAt(i));
            }
            else {
                //Setting the flag
                boolean isRedundant=true;
                //So once you encounter a closing bracket ,trace the stack till yoi get opening bracket
                //and check if some operator is in between them until opening bracket found
                //if found then set flag as false
                while(stack.peek()!='('){
                   if(stack.peek()=='+' || stack.peek()=='-' || stack.peek()=='*' || stack.peek()=='/'){
                       isRedundant=false;
                   }
                   //pop all things betwwen bracket
                   stack.pop();
                }
                //Now if nothing operator is found this flag will be true , hence redundant
                if(isRedundant==true){
                    return true;
                }
                //This pop is for opening opening bracket
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String exp="((a+b)+(b+c))";
        boolean answer=checkRedundantBrackets(exp);
        System.out.println(answer);


    }
}
