package com.ObjectOrientedProgramming.access;

public class SubClass extends A{ //Subclass is child of A
    public SubClass(int num, String name) {
        super(num,name);
    }
//name is private but as SubClass is public, we are able to access
    public static void main(String[] args) {
        SubClass obj = new SubClass(45,"Kunal Kushwaha");
        int n = obj.num;//Protected members can be accessed in subclass of same package
    }
}
