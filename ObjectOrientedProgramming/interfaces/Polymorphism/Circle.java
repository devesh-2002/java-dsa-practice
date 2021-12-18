package com.ObjectOrientedProgramming.Polymorphism;

public class Circle extends Shapes{
    @Override //If the func was not overridden it would have shown error
    void area(){
        System.out.println("Circle is pi*r square");
    }
}
//It will run when the obj of circle is created
//It is overriding the parent method
//Annotation @Override is used to check, if the method is being overridden
