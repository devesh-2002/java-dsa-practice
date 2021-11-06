package com.Recursion.Array;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1,3,2,5};
        System.out.println(sorted(arr,1));
    }
    static boolean sorted(int[] arr, int index){
        if(index==arr.length){ //When you are at the last index, it means array is sorted
            return true;
        }
        return arr[index]<arr[index+1] &&sorted(arr,index+1); //Recursive call
        //Index will never go out of bound as it returns true at last index

    }
}
