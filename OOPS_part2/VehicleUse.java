package com.OOPS_part2;

public class VehicleUse {


    public static void main(String[] args) {
        Vehicle v =new Vehicle();
//        v.color="red";
        v.setColor("red");
        v.getColor();
        v.print();

        Car c =new Car();
//        c.color="Black";
        c.setColor("Black");
        c.maxSpeed=100;
        c.numDoors=4;
        c.printCar();
    }
}
