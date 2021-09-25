package com.Practice;
import java.util.Arrays;
import java.util.Scanner;

public class CyclicSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        Cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //This sort is applicable when you have N numbers from 1 to N
    //Eg : [3,2,4,5,1] -> [1,2,3,4,5]
    //The first element gets swapped with element of correct index
    //3 which is arr[0] should be at arr[2] which is currently of 4
    //So 3 and 4 get swapped -> [4,2,3,5,1]
    //Similar way 4 should be at arr[3], so arr[0] gets swapped with arr[3] and this process continues
    //Time Complexity : O(N)
    static void Cyclicsort(int[] arr){
        int i=0;
        while(i<arr.length){
            int corr_index = arr[i] - 1; //Correct index will be element -1 because numbers are N and from 1 to N
            if(arr[i]!= arr[corr_index]){ //If element not at correct index, swap
                swap(arr,i,corr_index);
            }
            else{
                i++;
            }
        }
    }

     static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
