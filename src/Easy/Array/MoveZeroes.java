package Easy.Array;

import java.util.Arrays;

public class MoveZeroes {

    static void moverzero(int[] arr){
        int n = arr.length;
        int start = 0;
        for(int j = 0; j< n;j++){
            if(arr[j] != 0){
                arr[start++] = arr[j];
            }
        }
        while(start < n){
            arr[start++ ] = 0;

        }

    }


    public static void main(String[] args) {
        int[] arr = { 0,1,2,0,4,5};
        moverzero(arr);
        System.out.println(Arrays.toString(arr));
    }
}
