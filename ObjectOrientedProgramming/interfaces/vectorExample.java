package com.ObjectOrientedProgramming;

import java.util.List;
import java.util.Vector;

public class vectorExample {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>();
        vector.add(12);
        vector.add(23);
        vector.add(100);
        System.out.println(vector);
    }
}
//ArrayList is non synchronised -> Multiple Threading possible, while the same in Vector not possible
//Hence, ArrayList considered to be better
