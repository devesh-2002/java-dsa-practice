package com.ObjectOrientedProgramming.access;

public class ObjectDemo {
    int num;

    public ObjectDemo(int i) {
        super();
    }

    @Override
    public int hashCode() { //Gives number representation of the object
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() { //Gives string representation
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        //Called just before an object is Garbage Collected
        super.finalize();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(45);
        System.out.println(obj.getClass());
        System.out.println(obj.hashCode());
    }
}
