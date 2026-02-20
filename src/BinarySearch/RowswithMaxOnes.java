package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class RowswithMaxOnes {

    /// ou are given a 2D binary array arr[][] consisting of only 1s and 0s.
    /// Each row of the array is sorted in non-decreasing order.
    /// Your task is to find and return the index of the first row that contains the maximum number of 1s.
    /// If no such row exists, return -1.

    /// Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
    /// Output: 2
    /// Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.



    private static int rowwithMaxOnesBruteForce(int[][] matrix){

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1; // Edge case: empty matrix
        }

         int maxcount = 0;
         int maxrowindex = Integer.MIN_VALUE;
         for(int i =0; i< matrix.length;i++){
             int count = 0;
             for(int j = 0;j<matrix[0].length;j++){
                 if(matrix[i][j] == 1){
                     count++;
                 }
                 if(count>maxcount){
                     maxcount = count;
                     maxrowindex = i;
                 }
             }

         }
        return maxrowindex;
    }



    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1}
        };
        int result = rowwithMaxOnesBruteForce(mat);
        System.out.println(result);
    }
}
