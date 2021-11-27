package com.ObjectOrientedProgramming.interfaces;

public class NiceCar {
    private Media player = new CDPlayer();
    public void stopMusic(){
        player.stop();
    }
    public void startMusic(){
        player.start();
    }
}
