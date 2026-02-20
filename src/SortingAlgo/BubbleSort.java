package SortingAlgo;

import java.util.Arrays;

import static SortingAlgo.SelectionSort.swap;

public class BubbleSort {

    static void  bubbleSort(int[] arr){
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

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
