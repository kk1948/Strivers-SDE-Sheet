package Medium.Stack.MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextgreaterElement {

    /// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
    /// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    /// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and
    /// determine the next greater element of nums2[j] in nums2. If there is no next greater element,
    /// then the answer for this query is -1.
    /// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

    /// Example 1:
    ///
    /// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    /// Output: [-1,3,-1]
    /// Explanation: The next greater element for each value of nums1 is as follows:
    /// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    /// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
    /// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
    /// Example 2:
    ///
    /// Input: nums1 = [2,4], nums2 = [1,2,3,4]
    /// Output: [3,-1]
    /// Explanation: The next greater element for each value of nums1 is as follows:
    /// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
    /// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

    public static int[] nextgreaterelementbruteForce(int[] nums1, int[] nums2){
        int[] resultarr = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            for(int j =0;j <nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    int nextgreater =-1;
                    for (int k = j+1; k<nums2.length ; k++){
                        if(nums2[k] > nums2[j]){
                            nextgreater = nums2[k];
                            resultarr[i] = nextgreater;
                            break;
                        }
                    }
                    if(nextgreater == -1){
                        resultarr[i] = -1;
                    }
                }
            }
        }
        return resultarr;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int element = nums2[i];

            // Pop all smaller elements
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }

            // Map current element’s next greater
            map.put(element, stack.isEmpty() ? -1 : stack.peek());

            // Push current element
            stack.push(element);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }






    public static void main(String[] args) {
      int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
      int[] result =  nextGreaterElement(nums1, nums2);
        System.out.println(Arrays
                .toString(result));

    }
}
