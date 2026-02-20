package Medium.Array;

//import static SortingAlgo.SelectionSort.swap;

import java.util.Arrays;

public class SortzerooneTwos {

    /// Given an array nums with n objects colored red, white, or blue,
    /// sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    /// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    ///
    /// You must solve this problem without using the library's sort function.
    /// Example 1:
    ///
    /// Input: nums = [2,0,2,1,1,0]
    /// Output: [0,0,1,1,2,2]
    /// Example 2:
    ///
    /// Input: nums = [2,0,1]
    /// Output: [0,1,2]
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort0s1s2sbruteForce(int[] arr){
        //using bubble sort
        int n = arr.length;
        boolean swapped = false;
        for(int i = n-1; i>=1; i--){
            for(int j = 0; j<= i-1; j++ ) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }

            }
            if(!swapped) break;
        }
    }

    public static void sort0s1s2sdutchnationalalgo(int[] arr){
        //using bubble sort
        int n = arr.length;
        int low  =0, mid = 0, high = n -1;
        while (mid<=high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;

            } else if (arr[mid]==1) {
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2,0,2,1,1,0};
//        sort0s1s2sbruteForce(arr);
        sort0s1s2sdutchnationalalgo(arr);
        System.out.println(Arrays.toString(arr));
    }
}
