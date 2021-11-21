package com.ObjectOrientedProgramming;

class WrapperExample {

    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//
//        Integer num = 45;

        Integer a = 10;
        Integer b = 20;

        swap(a, b);

        System.out.println(a + " " + b);

//        final int bonus = 2;
//        bonus = 3;

        final A kunal = new A("Kunal Kushwaha");
        kunal.name = "other name";

        // when a non primitive is final, you cannot reassign it.
//        kunal = new A("new object");

        for (int i = 0; i < 1000000; i++) {
            A obj = new A("Random name");
        }
        //Doesn't get called at all, because of Garbage Collector, when i<1000
        //But Object gets destroyed when i is called way tooo many times
        //We can't do object.finalize() manually

    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

}

class A {
    final int num = 10;
    String name;

    public A(String name) {
//        System.out.println("object created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
    //Destructor
}
//You can't free the memory by yourself but you can tell what to do