package com.OOPS_part1;

public class FractionUse {

    public static void main(String[] args) {


        Fraction f1=new Fraction(4,6);
        f1.print();
//    f1.setNumerator(12);
//        f1.increment();
//        f1.print();

        Fraction f2=new Fraction(2,5);
        f2.print();

        //add f2 in f1
//        f1.add(f2);
//        f1.print();

        Fraction f3=Fraction.add(f1,f2);

        //add f1 and f2 and storing in f3
//        Fraction f3= Fraction.add(f1,f2);
        f3.print();


    }


}
