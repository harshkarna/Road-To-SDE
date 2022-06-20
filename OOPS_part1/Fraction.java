package com.OOPS_part1;

public class Fraction {

    private int numerator; //making private to have checks and control over varaibles
    private int denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator==0){
            //Throw Error
            denominator=1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd=1;
        int smaller =Math.min(numerator,denominator);
        for(int i=2;i<smaller;i++){
            if(numerator%i==0 && denominator%i==0){
                gcd=i;
            }
        }
        numerator=numerator/gcd;
        denominator=denominator/gcd;
    }


    public void  add(Fraction f2){
        //First fraction on which the function is called
        //Second function is passed as arguements
        this.numerator=this.numerator * f2.getDenominator() + this.denominator* f2.getNumerator();
        this.denominator= this.denominator * f2.getDenominator();
        simplify();
    }


    //adding 2 fractionsand storing result in new object
    public static Fraction add(Fraction f1, Fraction f2){
        int newNum=f1.numerator * f2.denominator + f1.denominator* f2.numerator;
        int newDen=f1.denominator * f2.denominator;
        Fraction f3= new Fraction(newNum, newDen);
        return f3;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
         if (denominator==0){
             //Throw Error
             return ;
         }
        this.denominator = denominator;
    }

    public void print(){
        System.out.println(numerator + "/"+ denominator);
    }

    public void increment() {
        numerator=numerator+denominator;
        simplify();
    }
}
