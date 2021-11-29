package com.ObjectOrientedProgramming.interfaces;

public class Car implements Engine,Break,Media{
    //You can implement more than one classes
    //while the same isn't possible for inheriting
    @Override
    public void brake() {
        System.out.println("Brake");
    }

    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerate");
    }
}
