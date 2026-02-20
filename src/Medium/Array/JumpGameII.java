package Medium.Array;

public class JumpGameII {

    /// You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
    /// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
    /// 0 <= j <= nums[i] and i + j < n
    /// Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
    /// Example 1:
    /// Input: nums = [2,3,1,1,4]
    /// Output: 2
    /// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    /// Example 2:
    /// Input: nums = [2,3,0,1,4]
    /// Output: 2


    public static int canJumpII(int[] nums) {
        int n = nums.length;

        // if only 1 element, already at last index
        if (n == 1) return 0;

        int jumps = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {  // notice: n-1 (no need to jump from last index)

            // update farthest reach
            farthest = Math.max(farthest, i + nums[i]);

            // if we reached the end of current jump range
            if (i == end) {
                jumps++;

                // move end to farthest possible
                end = farthest;

                // if end already reaches last index
                if (end >= n - 1) {
                    return jumps;
                }
            }

            // optional stuck case: if farthest never increases, can't move
            if (i == farthest && nums[i] == 0) {
                return -1; // not reachable
            }
        }

        return jumps;
    }




    public static void main(String[] args) {
           int[ ]  arr = { 2,3,1,1,4};
           int result = canJumpII(arr);
        System.out.println(result);
    }
}
