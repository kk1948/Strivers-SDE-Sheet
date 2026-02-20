package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPos {


    /// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    ///
    /// If target is not found in the array, return [-1, -1].
    ///
    /// You must write an algorithm with O(log n) runtime complexity.

    static int[] searchRangeBruteForce(int[] arr , int target){
       int first = -1;
       int last = -1;

       for(int i =0; i<arr.length; i++){

           if(arr[i] == target){
               if(first == -1){
                   first = i;

               }
               last = i;
           }
       }
       return new int[]{first, last};

    }


    public static void main(String[] args) {
        //int[]  nums = {5,7,7,8,8,10}; int target = 8;
        int[]  nums = {5,7,7,8,8,10}; int target = 6;
        int[] result = searchRangeBruteForce(nums, target);
        System.out.println(Arrays.toString(result));
        
    }
}
