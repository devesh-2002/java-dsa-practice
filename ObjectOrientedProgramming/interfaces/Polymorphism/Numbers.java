package com.ObjectOrientedProgramming.Polymorphism;
//Function Overloading
public class Numbers {
    int sum(int a, int b){
        return a+b;

    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
    //Same function name, different parameters
    public static void main(String[] args) {
        Numbers obj = new Numbers();
        System.out.println(  obj.sum(2,3));
        System.out.println(  obj.sum(1,2,3));
    }
}
