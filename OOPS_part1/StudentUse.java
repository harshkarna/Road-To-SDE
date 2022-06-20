package com.OOPS_part1;

import java.util.Scanner;

public class StudentUse {

    public static void main(String[] args) {

//        Scanner s = new Scanner(System.in);
          Student s1=new Student("harsh",12);
//          s1.print();
          Student s2=new Student("ankit",124);
          System.out.println(s1.getNumStudents());
          System.out.println(s2.getNumStudents());
          System.out.println(Student.getNumStudents());//better way to access static variable as with class name


//          s1.name="Harsh";
//          s1.rollNumber=1234;
//          System.out.println(s1.name +" "+ s1.rollNumber);
//           s1.setRollNumber(1234);

//           System.out.println(s1.name +" "+ s1.getRollNumber());




    }
}
