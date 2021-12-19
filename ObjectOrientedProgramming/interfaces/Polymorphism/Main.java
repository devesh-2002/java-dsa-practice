package com.ObjectOrientedProgramming.Polymorphism;
//Polymorphism
public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();

        shape.area();//It will see the object type and call respectively
        circle.area();//It will see the object type and call respectively
        square.area();//It will see the object type and call respectively
    }
}
