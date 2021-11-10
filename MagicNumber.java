package com.company.Maths;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 4;
        int ans = 0;
        int base = 5;
        /*
        No = ..5^3 5^2 5^1 (and so on)
        * 1 = 0 0 1 ->5
        * 2 = 0 1 0 -> 25
          3 = 0 1 1 -> 5^2 + 5^1 = 30
          4 = 1 0 0 -> 125
        * */
        while(n>0) {
            int last = n&1; //Last Binary Digit
            n = n>>1;
            ans+=last*base;
            base = base*5;
        }
        System.out.println(ans);
    }
}