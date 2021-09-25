package com.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        selection(arr);
        System.out.println(Arrays.toString(arr));
        //Time Complexity O(N2)
    }
    //2,3,0,1 -> last element and max will be swapped , so 2,1,0,3
    //Now second last and max out of remaining will be swapped and this continues..-> 0,1,2,3
    //Element which is max is swapped with the last element
    //This loop continues till all elements are swapped
    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i- 1; //Last element decreases as max gets swapped with last
            int maxIndex = getMaxIndex(arr, last); //finding max
            swap(arr, maxIndex, last); //last and maxIndex are swapped
        }
    }
    //swapping of 2 elements
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
//Finding max element
    static int getMaxIndex(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}






