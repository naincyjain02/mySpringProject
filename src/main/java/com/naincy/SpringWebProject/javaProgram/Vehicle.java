package com.naincy.SpringWebProject.javaProgram;

public sealed class Vehicle permits Car, Bike {
    public void drive() {
        System.out.println("Driving a vehicle");
    }
}
