package com.ObjectOrientedProgramming.Lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunc {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i+1);
            //1 to 5 numbers
        }
        arr.forEach((item)-> System.out.println(item*2));
        //One line nameless function, which prints twice of every element(item)
        //This is Lambda Function
        Consumer<Integer> fun = (item)-> System.out.println(item*2);
        //Consumer operation accepts a single input and gives no result
        arr.forEach(fun);

    }
}
//Lambda functions can be assigned to the type interfaces