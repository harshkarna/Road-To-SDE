package com.First_Steps;
//Check triangle
//
//You are given the lengths of 3 sides of a valid triangle. You need to print any one of the following outputs depending on the triangle's nature.
//Print 1, if the triangle is equilateral
//Print 0, if it's isosceles
//Print -1, if it's scalene
//Draw a flowchart for this process.
//Note : You don't need to submit the problem. Just attempt in your notebook and ask doubts if you need help.


public class checkTriangle {

    public static void checktriangle(int n1, int n2, int n3){

        if (n1==n2 && n2==n3){
            System.out.println("Equilateral");
        }
        else if (n1 ==n2 || n2==n3 || n3==n1){
            System.out.println("Isosecles");
        }
        else if (n1 !=n2 && n2!=n3 && n3!=n1){
            System.out.println("scalene");
        }

    }

    public static void main(String[] args) {
        checktriangle(15, 15, 15);
    }

}
