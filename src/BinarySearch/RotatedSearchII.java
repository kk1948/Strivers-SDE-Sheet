package BinarySearch;

public class RotatedSearchII {

    /// Given the array nums after the rotation(not necessarily with distinct values) and an integer target,
    /// return true if target is in nums, or false if it is not in nums.
    ///


    public static boolean searchBruteForceII(int[] nums, int target) {
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == target) return true;
        }

        return false;
    }

    public static int optimizedBinarySearchII(int[] nums, int target) {
        int low  = 0;
        int high = nums.length -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            //1 Case - if target lies in mid
            if(nums[mid] == target) return mid;

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }


            //either left sorted
            if (nums[low]<= nums[mid]){
                if(nums[low]<= target && target<= nums[mid]){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }
            //either right sorted
            else{
                if(nums[mid]<= target && target<=nums[high]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
      int[] nums = {2,5,6,0,0,1,2};
      int target = 0;
        boolean bruteForceII = searchBruteForceII(nums, target);
        System.out.println(bruteForceII);  //true
        boolean searchBruteForceII = searchBruteForceII(nums, target);
        System.out.println(searchBruteForceII);  // true
    }
}
