package BinarySearch;

public class RotatedSearch {
    ///Given the array nums after the possible rotation and an integer target, return the index of target
    /// if it is in nums, or -1 if it is not in nums.
    /// You must write an algorithm with O(log n) runtime complexity.

    public static int searchBruteForce(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return count;
            } else {
                count++;
            }
        }

        return -1;
    }

    public static int optimizedBinarySearch(int[] nums, int target) {
        int low  = 0;
        int high = nums.length -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            //1 Case - if target lies in mid
            if(nums[mid] == target) return mid;

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

        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        //int result = searchBruteForce(arr,target);
       // System.out.println(result);
        int result = optimizedBinarySearch(arr, target);
        System.out.println(result);
    }
}
