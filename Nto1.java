package com.Practice;
import java.util.*;
public class Nto1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        Ntoone(n);
        onetoN(n);
    }
    static void Ntoone (int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        Ntoone(n-1);

    }
    static void onetoN(int n){
        if(n==0){
            return;
        }
        onetoN(n-1); //First calling the function
        //Then print the number
        System.out.println(n);
    }
    //If we want to print both the ways 1 to n and n to 1 then,
    static void both(int n){
        if(n==0){
            return;
        }
    }
}
