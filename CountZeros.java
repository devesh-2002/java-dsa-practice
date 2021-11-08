package com.Recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(count(130300));
    }
    static int count(int n){
        return helper(n,0);
    }

    private static int helper(int n, int c) {
        if(n==0){
             return c;
        }
        int rem = n%10;
        if(rem==0){ //If the number is divisible by 10, count inc by 1
            return helper(n/10,c+1);
        }
        return helper(n/10,c);//If it isn't divisible by 10 then next number of n-1 digits is seen
        //count doesn't increase
    }
}
