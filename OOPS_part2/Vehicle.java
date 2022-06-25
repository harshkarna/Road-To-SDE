package com.OOPS_part2;

public class Vehicle {

    private String color;
    int maxSpeed;

    public String getColor(){
        return color;
    }

    public void  setColor(String color){
        this.color=color;
    }

    public void print(){
        System.out.println("Vehicle Color "+ color + " maxspeed "+ maxSpeed);
    }

}
