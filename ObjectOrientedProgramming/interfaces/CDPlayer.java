package com.ObjectOrientedProgramming.interfaces;

public class CDPlayer implements Media {
    @Override
    public void start() {
        System.out.println("Start CD Player");
    }

    @Override
    public void stop() {
        System.out.println("Stop CD Player");
    }
}
