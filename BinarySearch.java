package com.Practice;
import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        int m = input.nextInt();
        System.out.println(BS(arr,m));
    }
    //Applicable for Sorted Arrays
    static int BS(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }

        }
        return -1;
    }
}
