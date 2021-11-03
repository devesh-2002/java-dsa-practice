package com.Recursion;
import java.util.*;
public class Product1toN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fact(n));
    }
    static long fact(int n){
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }
}
