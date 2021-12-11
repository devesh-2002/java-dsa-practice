package com.ObjectOrientedProgramming.interfaces.nestedInterface;

public interface A {
    public interface NestedInterface{
        //Interface inside a class or another interface is nestedInterface
        boolean isOdd(int num);
    }

}
class B implements A.NestedInterface{
    //Accessing the NestedInterface which is inside A
    @Override
    public boolean isOdd(int num) {
        return (num&1)==1; //Bitwise Operators
    }
}
