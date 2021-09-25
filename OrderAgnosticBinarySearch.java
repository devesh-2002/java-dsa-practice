package com.Practice;
import java.util.Scanner;

public class OrderAgnosticBinarySearch {

        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = input.nextInt();
            }
            int target = input.nextInt();
            System.out.println(AOBS(arr,target));
            input.close();
        }
        static int AOBS(int arr[],int target){
            int start = 0;
            int end = arr.length - 1;

            // find whether the array is sorted in ascending or descending

            boolean isAsc = arr[start] < arr[end];

            while(start <= end) {
                // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    return mid;
                }

                if (isAsc) {
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

