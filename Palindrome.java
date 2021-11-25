package com.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palin(1234321 ));
    }
    static int rev(int n) {
        // sometimes you might need some additional variables in the argument
        // in that case, make another function
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n%10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
        //1234 = 1*10^3 + 2*10^2+3*10^1+4*10^0

    }
    static boolean palin(int n){
        return n==rev(n);
    }

}
