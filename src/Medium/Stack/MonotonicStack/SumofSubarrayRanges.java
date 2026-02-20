package Medium.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class SumofSubarrayRanges {

    public static  int sumofsubarrayRangesBruteForce(int[] arr){
        int n = arr.length ;
        int rangesum = 0;

        for (int i = 0;i< n; i++){
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j< n;j++){
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

               rangesum = rangesum + max - min;
            }
        }
        return rangesum;
    }


    public static  long sumofsubarrayRangesOptimizedApproach(int[] arr){
        int n = arr.length;

        int[] nse = new int[n]; // next smaller
        int[] pse = new int[n]; // previous smaller
        int[] nge = new int[n]; // next greater
        int[] pge = new int[n]; // previous greater

        Arrays.fill(nse, n);
        Arrays.fill(nge, n);
        Arrays.fill(pse, -1);
        Arrays.fill(pge, -1);

        Stack<Integer> st = new Stack<>();

        // ---------- Next Smaller Element ----------
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                nse[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        // ---------- Previous Smaller Element ----------
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                pse[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        // ---------- Next Greater Element ----------
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                nge[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        // ---------- Previous Greater Element ----------
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                pge[st.pop()] = i;
            }
            st.push(i);
        }

        // ---------- Contribution ----------
        long res = 0;

        for (int i = 0; i < n; i++) {
            long minContribution = (long) (i - pse[i]) * (nse[i] - i) * arr[i];
            long maxContribution = (long) (i - pge[i]) * (nge[i] - i) * arr[i];
            res += maxContribution - minContribution;
        }

        return res;
    }





    public static void main(String[] args) {
       //int[] nums = {1,2,3};
       int[] nums = {1,3,3};
      int result =  sumofsubarrayRangesBruteForce(nums);
        System.out.println(result);


    }
}
