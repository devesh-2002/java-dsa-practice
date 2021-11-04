package com.Recursion;

public class SumofDigits {
    public static void main(String[] args) {
        int ans = 346;
        System.out.println(sumDigit(ans));
    }
    static int sumDigit(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+ sumDigit(n/10);
    }
}
