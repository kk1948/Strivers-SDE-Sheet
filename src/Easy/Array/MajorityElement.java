package Easy.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /// Given an array nums of size n, return the majority element.
    /// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    /// Example 1:
    /// Input: nums = [3,2,3]
    /// Output: 3
    /// Example 2:
    /// Input: nums = [2,2,1,1,1,2,2]
    /// Output: 2




    //method 1- sort the array

    static int majorityone(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n / 2];
    }





    //method 2- using hashtable
    static int majoritytwo(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2)
                return num;
        }
        return -1;
    }

    //Moore voting algo

    static int majoritythree(int[] nums){
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }


    public static void main(String[] args) {
       int[] arr = {2,2,1,1,1,2,2};
      // int res = majorityone(arr);
       int res = majoritythree(arr);

        System.out.println(res);
    }
}
