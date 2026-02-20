package BinarySearch;

public class FindMininRotatedArray {

    /// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    ///For example, the array nums = [0,1,2,4,5,6,7] might become:
    /// [4,5,6,7,0,1,2] if it was rotated 4 times.
    /// [0,1,2,4,5,6,7] if it was rotated 7 times.
    /// You must write an algorithm that runs in O(log n) time.
    ///https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    public  static int  findMinBinaryDearch(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<= high){
           int mid =  low +( high - low) / 2;
           if(arr[low]<=arr[mid]){
               ans = Math.min(ans, arr[low]);
               low = mid +1;
           }else{
               ans= Math.min(ans,arr[mid]);
               high = mid - 1;
           }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
          int result =    findMinBinaryDearch(nums);
        System.out.println(result);
    }
}
