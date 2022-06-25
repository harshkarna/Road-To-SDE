package com.OOPS_part2;

public class Car extends Vehicle{

    int numDoors;

    public void printCar(){
        System.out.println("Vehicle Color "+ getColor() + " maxspeed "+ maxSpeed + " Number of Doors "+ numDoors);
    }
}
