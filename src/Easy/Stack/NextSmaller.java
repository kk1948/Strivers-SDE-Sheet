package Easy.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextSmaller {

    public static int[] nextsmallerbruteForce(int[] nums){
        int[] nSE = new int[nums.length];
        nSE[0] = -1;

        for (int i = 1; i<nums.length ; i++){
            nSE[i] = -1;  // default if no smaller element found

            // search left side
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    nSE[i] = nums[j]; // nearest smaller
                    break;            // STOP at nearest
                }
            }
        }
        return nSE;

    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) { //arraylist version

        ArrayList<Integer> result = new ArrayList<>();

        // First element has no left side
        result.add(-1);

        for (int i = 1; i < A.size(); i++) {
            int ans = -1;  // default if no smaller element exists

            // search left side
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) < A.get(i)) {
                    ans = A.get(j);  // nearest smaller
                    break;           // stop at nearest
                }
            }

            result.add(ans);
        }

        return result;
    }

    public static int[] nextsmallerMonotonicStack(int[] nums){
        int[] nSE = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< nums.length; i++){
            while(!stack.isEmpty() && stack.peek()>nums[i]){
                stack.pop();
            }
            nSE[i] = stack.empty()?-1: stack.peek();
            stack.push(nums[i]);
        }
        return nSE;

    }

    public static ArrayList<Integer> prevSmaller1(ArrayList<Integer> A) {//arraylist version

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {

            // Remove elements >= current
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }

            // Top is nearest smaller on the left
            result.add(stack.isEmpty() ? -1 : stack.peek());

            // Push current element for future
            stack.push(A.get(i));
        }

        return result;
    }




    public static void main(String[] args) {
        int[ ] nums = {4, 5, 2, 10, 8 };
        //int[] result = nextsmallerbruteForce(nums);
        int[] result = nextsmallerMonotonicStack(nums);
        System.out.println(Arrays.toString(result));
    }
}
