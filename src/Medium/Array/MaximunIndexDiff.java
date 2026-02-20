package Medium.Array;

public class MaximunIndexDiff {
    /// Given an array arr of positive integers. You have to return the maximum of j - i such that arr[i] < arr[j] and i < j.
    ///
    /// Examples:
    ///
    /// Input: arr[] = [1, 10]
    /// Output: 1
    /// Explanation: arr[0] < arr[1] so (j-i) is 1-0 = 1.
    /// Input: arr[] = [5, 4, 3]
    /// Output: 0
    /// Explanation: There is no pair that satisfies the given condition.
    /// Input: arr[] = [34, 8, 10, 3, 2, 80, 30, 33, 1]
    /// Output: 6
    /// Explanation: In the given array arr[1] < arr[7] satisfying the required condition(arr[i] < arr[j]) thus giving the maximum difference of j - i which is 6(7-1).
    /// Constraints:
    /// 1 ≤ arr.size ≤ 10^5
    /// 0 ≤ arr[i] ≤ 10^9


   public static int maxIndexDiffBruteForce(int[] arr) {
        // code here
        int result = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = arr.length-1; j>=0; j--){
                if( arr[i] <= arr[j]){
                    result = Math.max((j-i), result);
                    break;

                }
            }
        }

        return result;

    }

    public static int maxIndexDiffOptimized(int[] arr) {

       //left prefix array
      int[] lmin = new int[arr.length];

      //right max suffix
      int[] rmax = new int[arr.length];


      //building left prefix array
        lmin[0] = arr[0];
      for(int i=1; i<arr.length; i++){
          lmin[i] = Math.min(lmin[i-1], arr[i]);
      }


      //building right prefix array
        rmax[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length - 2; j >= 0; j--){
            rmax[j] = Math.max(rmax[j + 1], arr[j]);
        }

        //using 2 pointer
        int k = 0;
        int l = 0;
        int maxindexdiff = -1;
        while(k< arr.length && l< arr.length){
            if(lmin[k]<= rmax[l]){
                maxindexdiff= Math.max(maxindexdiff, (l - k));
                l++;
            }else{
                k++;
            }
        }
        return maxindexdiff;

    }


    public static void main(String[] args) {
         int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1 };
        // int result = maxIndexDiffBruteForce(arr);
         int result = maxIndexDiffOptimized(arr);

        System.out.println(
                result
        );
    }
}
