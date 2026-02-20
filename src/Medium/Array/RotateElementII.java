package Medium.Array;

import java.util.Arrays;

public class RotateElementII {
    /// Rotate an array by one Place

    static void rotateKPlaceBruteForce(int[] arr, int d){
        int n = arr.length;

                // Step 1: Create a temporary array
                int[] temp = new int[d];
                for (int i = 0; i < d; i++) {
                        temp[i] = arr[i];
                }

                // Step 2: Shift the remaining elements
                for (int i = d; i < n; i++) {
                        arr[i - d] = arr[i];
                }

                // Step 3: Append the temporary array
                for (int i = 0; i < d; i++) {
                       arr[n - d + i] = temp[i];
                }
    }


    static void rotateleftKPlaceOptimized(int[] arr, int d){
        // Function to reverse a portion of the array
       int n = arr.length;
       d = d % n; //handle cases where d > n
        reverse(arr,0,d-1); // Step 1: Reverse first D elements
        reverse(arr,d , n-1);  // Step 2: Reverse remaining elements
        reverse(arr, 0, n-1); // Step 3: Reverse the entire array
    }

    static void rotaterightKPlaceOptimized(int[] arr, int k){
        // Function to reverse a portion of the array
        int n = arr.length;
        k = k %  n;

        reverse(arr,0,n-1); //Reverse the entire array
        reverse(arr, 0, k-1);  // Step 2: Reverse first K elements
        reverse(arr, k, n-1);   // Reverse the remaining element

    }

    static void reverse(int[] arr, int start, int end){
        while(start< end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }





    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,4 ,5,6,7};
        rotateKPlaceBruteForce(arr, 3 );
        //rotateleftKPlaceOptimized(arr, 2);
        //rotaterightKPlaceOptimized(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
