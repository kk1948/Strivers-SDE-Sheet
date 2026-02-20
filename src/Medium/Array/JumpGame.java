package Medium.Array;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    public static int canJumpIII(int[] nums) {
//        int jump =0;
//        int count = 0;
//
//
//        for(int i = 0;i< nums.length; i++){
//            if(i> jump) return 0;
//            jump = Math.max(jump, i+nums[i]);
//
//              count++;
//            if(jump >= nums.length -1){
//                return count;
//            }
//
//        }
//
//        return count;


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
           int[ ]  arr = { 1,2,1,1,1};   //[1,2,1,1,1]
           int result = canJumpIII(arr);
          /// boolean result = canJump(arr);
        System.out.println(result);
    }
}
