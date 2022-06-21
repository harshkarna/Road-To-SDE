package com.OOPS_part1;

public class ComplexNumberUse {

    public static void main(String[] args) {

        ComplexNumber c1=new ComplexNumber(2,3);
        c1.print();
        c1.setReal(3);
        c1.setImaginary(8);
        c1.print();

        ComplexNumber c2=new ComplexNumber(1,2);
        c1.add(c2);
        c1.print();
        c2.print();

        ComplexNumber c3=new ComplexNumber(3,1);
        c3.print();
        c3.multiply(c2);
        c3.print();

        ComplexNumber c4 =ComplexNumber.add(c1,c2);
        c4.print();

    }
}
