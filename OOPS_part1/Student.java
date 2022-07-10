package com.OOPS_part1;

public class Student {
      String name;
      private int rollNumber;
      double cgpa;
      //final means that you cannnot change this variable value after the assignment
      final static double CONVERSIONFACTOR = 0.95;  //STATIC CONSTANT
      //here static is shared by all objects and it belongs to class not object
      private static int numStudents;
      //making it private



//      public int getRollNumber(){
//            return rollNumber;
//      }
//
//      public void setRollNumber(int num){
//            if (num <=0){
//                  return ;
//            }
//            rollNumber=num;
//       }

      //like here we want was some control over setting up the object creation
      public Student(String name, int rollNumber) { //constructor
            this.name = name;
            this.rollNumber = rollNumber;
            numStudents++;
      }

//      if we want to dynamically increment roll number as soon as object is being created
            public Student(String name) { //constructor
                  this.name = name;
                  numStudents++;
                  this.rollNumber = numStudents;
            }


      //we can create a constructor on 1 variable also
//      public Student(String name) {
//            this.name = name;
//      }


      //for deafault variables creation
//      public Student() {
//            this.name = "abc";
//            this.rollNumber = 10;
//      }

      //creating print constructor and its similar to a function
      public void print(){
            System.out.println(name +" "+rollNumber);
      }

      public int getRollNumber() {
            return rollNumber;
      }

      public void setRollNumber(int rollNumber) {

            this.rollNumber = rollNumber; //this is a reference to the object on which this function is called
      }


      public static int getNumStudents() {
            return numStudents;
      }
}
