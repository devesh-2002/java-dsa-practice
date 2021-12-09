package com.Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    static void sort(int[] nums,int low, int high){
        if(low>=high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = nums[mid]; //Pivot can be taken anything, in this case taken as mid of the array
        while (start<=end){
            while(nums[start]<pivot){
                start++;
            }
            while(nums[end]>pivot){
                end--;
            }
            //Swapping the elements if start<end
            if(start<=end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
        sort(nums,low,end);
        sort(nums,start,high);
        //Recursive calls
        //Repetitively gets swapped
        //[5,4,3,2,1]
        //3 is pivot, then [5,4] and [2,1] are taken into consideration
        //Now, 5 and 1, and 4 and 2 get swapped
    }
}
