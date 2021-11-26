package com.ObjectOrientedProgramming.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate();
        car.stop();
        car.start();
        car.brake();

      //  Media carMedia = new Car();
      //  carMedia.stop();
        //Gives the same output of the Car.stop

        NiceCar car1 = new NiceCar();
        car1.startMusic();
    }
}
//It determines which particular method to run at run-time
