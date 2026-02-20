package SortingAlgo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {


    static void  selectionSort(int[] arr){
        for(int i =0; i< arr.length;i++){
            int minindex = i;
            for(int j = i+1 ; j< arr.length ;j++){
               if(arr[j] < arr[minindex]) minindex = j;
            }

//            int temp = arr[i];
//            arr[i] = arr[minindex];
//            arr[minindex] = temp;

            swap(arr, i , minindex);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




        public static void main (String[] args) {
        int[] arr = { 64, 25, 12, 22, 11};
          selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


}
