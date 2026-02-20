package Easy.Array;

public class SingleElement {
    /// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    ///
    /// You must implement a solution with a linear runtime complexity and use only constant extra space.
    /// Example 1
    /// Input: nums = [2,2,1]
    /// Output: 1
    ///
    /// Example 2:
    /// Input: nums = [4,1,2,1,2]
    /// Output: 4

    static  int singleElementOptimized(int[] nums){
        int xor =0;
        for(int item : nums){
            xor ^= item;
        }
        return xor;
    }



    public static void main(String[] args) {
          int[] nums = {4,1,2,1,2};
          int result = singleElementOptimized(nums);
        System.out.println(result);
    }
}
