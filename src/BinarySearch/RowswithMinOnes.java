package BinarySearch;

public class RowswithMinOnes {

   /// Given a 2D binary matrix(1-based indexed) mat of dimensions nxm , determine the row that contains the minimum number of 1's.
   /// Note: The matrix contains only 1's and 0's. Also, if two or more rows contain the minimum number of 1's,
   ///the answer is the lowest of those indices.

   /// Input: mat = [[1, 1, 1, 1], [1, 1, 0, 0], [0, 0, 1, 1], [1, 1, 1, 1]]
   /// Output: 2
   /// Explanation: Rows 2 and 3 contain the minimum number of 1's (2 each). Since, row 2 is less than row 3.
   /// Thus, the answer is 2.



    private static int rowwithMinOnesBruteForce(int[][] matrix){

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1; // Edge case: empty matrix
        }

        int minCount = Integer.MAX_VALUE;
        int minRowIndex = -1;
         for(int i =0; i< matrix.length;i++){
             int count = 0;
             for(int j = 0;j<matrix[0].length;j++){
                 if(matrix[i][j] == 1){
                     count++;
                 }

             }
             if(count<minCount){
                 minCount = count;
                 minRowIndex = i;
             }
         }
        return minRowIndex + 1;
    }



    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 1}
        };
        int result = rowwithMinOnesBruteForce(mat);
        System.out.println(result);
    }
}
