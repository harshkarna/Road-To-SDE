package com.OOPS_part2;

public class ExceptionDemo {

    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
//           throw new ArithmeticException();
        }
        return a / b;
    }


    public static void main(String[] args) throws DivideByZeroException {

        try {
            divide(10, 0);
        } catch (DivideByZeroException e) {
            System.out.println("Divide by zero exception raised");
//            e.printStackTrace();
        }
        finally {
            System.out.println("Inside Finally");
        }
        System.out.println("Main");
    }
}

