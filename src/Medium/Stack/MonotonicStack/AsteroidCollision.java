package Medium.Stack.MonotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    /// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
    /// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
    /// Find out the state of the asteroids after all collisions.
    ///If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

    /// Example 1:
    /// Input: asteroids = [5,10,-5]
    /// Output: [5,10]
    /// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

    /// Example 2:
    /// Input: asteroids = [8,-8]
    /// Output: []
    /// Explanation: The 8 and -8 collide exploding each other.

    /// Example 3:
    /// Input: asteroids = [10,2,-5]
    /// Output: [10]
    /// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
    /// Example 4:


    public static int[] asteroidCollision(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for (int a : arr) {

            boolean destroyed = false;

            if (a < 0) {
                while (!stack.isEmpty() && stack.peek() > 0) {

                    if (stack.peek() < -a) {
                        stack.pop();
                    } else if (stack.peek() == -a) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) {
                    stack.push(a);
                }
            } else {
                stack.push(a);
            }
        }

        // convert stack to int[]
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }

    public static int[] asteroidCollisionlistversion(int[] arr) {

        List<Integer> stack = new ArrayList<>();

        for (int a : arr) {

            boolean destroyed = false;

            if (a < 0) {
                while (!stack.isEmpty() && stack.get(stack.size() - 1) > 0) {

                    int top = stack.get(stack.size() - 1);

                    if (top < -a) {
                        stack.remove(stack.size() - 1);   // pop
                    }
                    else if (top == -a) {
                        stack.remove(stack.size() - 1);
                        destroyed = true;
                        break;
                    }
                    else {
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) {
                    stack.add(a);   // push
                }

            } else {
                stack.add(a);       // push positive
            }
        }

        // Convert List → int[]
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }


    public static void main(String[] args) {
          int[] arr = {5,10,-5};
          //int[] arr = {10,2,-5};
         // int[] arr = {8,-8};
          int[] result = asteroidCollisionlistversion(arr);
        System.out.println(Arrays.toString(result));
    }
}
