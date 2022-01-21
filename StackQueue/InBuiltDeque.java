package com.StackQueue;
import java.util.ArrayDeque;
import java.util.Deque;

public class InBuiltDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        //ArrayDeque class provides interface to create an object like Deque interface
        //resizeable array; no capacity restrictions
        //faster than LL and stack, because insertion deletion from both ends
        deque.add(13);
        deque.add(123);
        deque.add(1234);
        deque.add(12345);
        System.out.println(deque);
    }
}
