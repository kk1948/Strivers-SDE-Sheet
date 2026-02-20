package Easy.Array;

import java.util.Arrays;

public class RotateElement {
    /// Rotate an array by one Place

    static void rotateOnePlace(int[] arr){
        int n = arr.length;
        int temp = arr[arr.length - 1];

        for(int i = n-2; i>=0; i-- ){
            arr[i+1] = arr[i];

        }

        arr[0] = temp;
    }






    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,4 ,5};
        rotateOnePlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
