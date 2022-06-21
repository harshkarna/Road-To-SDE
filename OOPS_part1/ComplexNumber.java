package com.OOPS_part1;

public class ComplexNumber {

    private int real ;
    private int imaginary;


    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(ComplexNumber c2){
        this.real=this.real +c2.real;
        this.imaginary=this.imaginary+c2.imaginary;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        int newReal= c1.real + c2.real;
        int newImag=c1.imaginary+c2.imaginary;
        ComplexNumber c4 =new ComplexNumber(newReal,newImag);
        return c4;
    }

    public void multiply(ComplexNumber c2){
        int real= this.real * c2.real + ((-1) * (this.imaginary * c2.imaginary)) ;
        int imaginary=this.imaginary *c2.real + this.real * c2.imaginary;;

        this.real= real;
        this.imaginary= imaginary;
    }

    public void print(){
        System.out.println(real +" + "+ imaginary+"i");
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
}
